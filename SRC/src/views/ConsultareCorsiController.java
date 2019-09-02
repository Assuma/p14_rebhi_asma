package views;

import connessione_al_database.MyDB;
import entità.Appello;
import entità.CorsoDiStudio;
import entità.Insegnamento;
import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import servizio.Service;


public class ConsultareCorsiController implements Initializable {

    @FXML
    private TableView<Insegnamento> table;
    @FXML
    private TableColumn<Insegnamento, String> specialite;
    @FXML
    private TableColumn<Insegnamento, String> nom;
    @FXML
    private TableColumn<Insegnamento, String> description;
    @FXML
    private TableColumn<Insegnamento, String> coeff;

                public ObservableList<Insegnamento>data=FXCollections.observableArrayList();
    @FXML
    private TextField inputRechercher;

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
             ResultSet rest = stm.executeQuery("select * from insegnamento");

            
            while (rest.next()) {
              
                data.add(new Insegnamento(rest.getInt(1), rest.getInt(3), rest.getString(4), rest.getString(5), rest.getInt(6)));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Appello.class.getName()).log(Level.SEVERE, null, ex);
        }


         specialite.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Insegnamento, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Insegnamento, String> param) {
                CorsoDiStudio u = new CorsoDiStudio();
                Service us = new Service();

                u = us.getSpecialitaById(param.getValue().getCorsoDiStudio());
                return new SimpleStringProperty(u.getNome());
            }
        });
 
        nom.setCellValueFactory(new PropertyValueFactory<>("description"));
        description.setCellValueFactory(new PropertyValueFactory<>("nome"));
        coeff.setCellValueFactory(new PropertyValueFactory<>("cfu"));
        table.setItems(data);

    
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
         Parent page1 = FXMLLoader.load(getClass().getResource("/views/MainPage.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Rechercher(ActionEvent event) {
       
          specialite.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Insegnamento, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Insegnamento, String> param) {
                CorsoDiStudio u = new CorsoDiStudio();
                Service us = new Service();

                u = us.getSpecialitaById(param.getValue().getCorsoDiStudio());
                return new SimpleStringProperty(u.getNome());
            }
        });
 
        nom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        coeff.setCellValueFactory(new PropertyValueFactory<>("cfu"));
       
        String a = inputRechercher.getText();
              System.out.println("AAAAAAAAAAAAAAAAAAAAAA"+a);

        
             Service bp = new Service();
        List<Insegnamento> list = bp.getAllMaterieByNome(a);
        ObservableList<Insegnamento> items = FXCollections.observableArrayList(list);
        table.setItems(items);
        
       
       
    }
    
}
