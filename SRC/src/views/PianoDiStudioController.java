
package views;

import com.sun.prism.impl.Disposer;
import connessione_al_database.MyDB;
import entità.Insegnamento;
import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import servizio.ButtonCellPianoSt;
import servizio.Service;


public class PianoDiStudioController implements Initializable {

    @FXML
    private TableView<Insegnamento> tablePlanEtudes;
    @FXML
    private Button retourB;
    @FXML
    private TableColumn<Insegnamento, String> nom;
    @FXML
    private TableColumn<Insegnamento, String> description;
    @FXML
    private TableColumn<Insegnamento, Integer> coefficient;
    @FXML
    private TableColumn<Disposer.Record, Boolean> action;

        public ObservableList<Insegnamento>data=FXCollections.observableArrayList();
    @FXML
    private TableView<Insegnamento> monTable;
    @FXML
    private TableColumn<Insegnamento, String> monNom;
    @FXML
    private TableColumn<Insegnamento, String> monDescription;
    @FXML
    private TableColumn<Insegnamento, Integer> monCoefficient;
        public ObservableList<Insegnamento>data1=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Service es = new Service();
            Studente etudiant = es.getStudentById(LoginMemberController.getIdCnx());
                    

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from insegnamento i where NOT EXISTS ( SELECT * from insegnamento_utente u where u.listInsegnamento_codice = i.codice and u.listUtente_matricola ="+LoginMemberController.getIdCnx()+" ) and i.annoDiStudi ='"+etudiant.getAnnoSt()+"'");

            
            while (rest.next()) {
                data.add(new Insegnamento(rest.getInt(1), rest.getInt(3), rest.getString(4), rest.getString(5)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Insegnamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        nom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        coefficient.setCellValueFactory(new PropertyValueFactory<>("cfu"));
         action.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Disposer.Record, Boolean>, ObservableValue<Boolean>>() {

            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Disposer.Record, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        //Adding the Button to the cell
        action.setCellFactory(new Callback<TableColumn<Disposer.Record, Boolean>, TableCell<Disposer.Record, Boolean>>() {

            @Override
            public TableCell<Disposer.Record, Boolean> call(TableColumn<Disposer.Record, Boolean> p) {
                return new ButtonCellPianoSt();
            }

        });
       
        
        tablePlanEtudes.setItems(data);

    
    
    
    
    
    
    
    
    
    
    
    
    
     try {
     Service es = new Service();

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from insegnamento_utente  where listUtente_matricola ="+LoginMemberController.getIdCnx()+"");

            
            while (rest.next()) {
                data1.add(es.getMateriaById(rest.getInt(1)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Insegnamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        monNom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        monDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        monCoefficient.setCellValueFactory(new PropertyValueFactory<>("cfu"));
        /* etat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Insegnamento, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Insegnamento, String> param) {
                Prenotazione u = new Prenotazione();
                EtudiantService us = new EtudiantService();

                u = us.getEtatByIDMatiere(param.getValue().getCodice());
                return new SimpleStringProperty(u.getStato());
            }
        }); */
        monTable.setItems(data1);

    
    
    
    
    
    
    
    
    
    
    
    }
    

    @FXML
    private void retour(ActionEvent event) throws IOException {

        Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioStudente.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
