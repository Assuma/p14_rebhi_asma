package views;

import com.sun.prism.impl.Disposer;
import connessione_al_database.MyDB;
import entità.Appello;
import entità.Insegnamento;
import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import servizio.ButtonCelPrenotazione;
import servizio.Service;

public class PrenotareEsameController implements Initializable {

    @FXML
    private TableView<Appello> table;
    @FXML
    private TableColumn<Appello, String> nom;
    @FXML
    private TableColumn<Appello, String> description;
    @FXML
    private TableColumn<Appello, String> coefficient;
    @FXML
    private TableColumn<Appello, String> salle;
    @FXML
    private TableColumn<Appello, Date> date;
    @FXML
    private TableColumn<Appello, String> descAppollo;
    @FXML
    private TableColumn<Appello, Double> duree;
    @FXML
    private TableColumn<Disposer.Record, Boolean> action;

    public ObservableList<Appello> data = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Service es = new Service();
            Studente etudiant = es.getStudentById(LoginMemberController.getIdCnx());

            Date dateX = new Date();
            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from appello i where i.date > CURDate() and NOT EXISTS ( SELECT * from prenotazione u where u.idAppello = i.id and u.idStudente =" + LoginMemberController.getIdCnx() + " )");

            while (rest.next()) {
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = formatter.parse(rest.getString(3));

                data.add(new Appello(rest.getInt(1), rest.getString(2), date, rest.getString(4), rest.getDouble(5), rest.getInt(6), rest.getInt(7)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Appello.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PrenotareEsameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        nom.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appello, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Appello, String> param) {
                Insegnamento u = new Insegnamento();
                Service us = new Service();

                try {
                    u = us.getMateriaById(param.getValue().getInsegnamento());
                } catch (SQLException ex) {
                    Logger.getLogger(PrenotareEsameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new SimpleStringProperty(u.getNome());
            }
        });

        description.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appello, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Appello, String> param) {
                Insegnamento u = new Insegnamento();
                Service us = new Service();

                try {
                    u = us.getMateriaById(param.getValue().getInsegnamento());
                } catch (SQLException ex) {
                    Logger.getLogger(PrenotareEsameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new SimpleStringProperty(u.getDescription());
            }
        });

        coefficient.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appello, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Appello, String> param) {
                Insegnamento u = new Insegnamento();
                Service us = new Service();

                try {
                    u = us.getMateriaById(param.getValue().getInsegnamento());
                } catch (SQLException ex) {
                    Logger.getLogger(PrenotareEsameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new SimpleStringProperty("" + u.getCfu());
            }
        });

        salle.setCellValueFactory(new PropertyValueFactory<>("aula"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        descAppollo.setCellValueFactory(new PropertyValueFactory<>("description"));
        duree.setCellValueFactory(new PropertyValueFactory<>("durata"));

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
                return new ButtonCelPrenotazione();

            }

        });

        table.setItems(data);

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
