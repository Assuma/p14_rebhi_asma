package views;

import connessione_al_database.MyDB;
import entità.Appello;
import entità.Insegnamento;
import entità.Prenotazione;
import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.util.Callback;
import servizio.Service;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class InserireVotoController implements Initializable {

    @FXML
    private TableView<Prenotazione> table;
    @FXML
    private TableColumn<Prenotazione, String> nomMatiere;
    @FXML
    private TableColumn<Prenotazione, String> nomEtudiant;
    @FXML
    private TableColumn<Prenotazione, String> note;

    public ObservableList<Prenotazione> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        table.setEditable(true);
        try {

            Service es = new Service();

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from prenotazione p JOIN appello a where p.idAppello=a.id and a.docente_matricola=" + LoginMemberController.getIdCnx() + "");

            while (rest.next()) {
                data.add(new Prenotazione(rest.getInt(1), rest.getInt(2), rest.getInt(3), rest.getString(4)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Appello.class.getName()).log(Level.SEVERE, null, ex);
        }

        nomMatiere.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                Insegnamento u = new Insegnamento();
                Service us = new Service();

                u = us.getMateriaByIdAppello(param.getValue().getAppello());
                return new SimpleStringProperty(u.getNome());
            }
        });

        nomEtudiant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                Studente u = new Studente();
                Service us = new Service();

                try {
                    u = us.getStudentById(param.getValue().getStudente());
                } catch (SQLException ex) {
                    Logger.getLogger(PrenotareEsameController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new SimpleStringProperty(u.getNome() + ' ' + u.getCognome());
            }
        });

        note.setCellValueFactory(new PropertyValueFactory<>("voto"));
        note.setCellFactory(TextFieldTableCell.<Prenotazione>forTableColumn());

        note.setOnEditCommit((CellEditEvent<Prenotazione, String> event) -> {
            TablePosition<Prenotazione, String> pos = event.getTablePosition();

            String newVoto = event.getNewValue();

            int row = pos.getRow();

            Service es = new Service();
            Prenotazione p = table.getSelectionModel().getSelectedItem();
            double aa = Double.parseDouble(newVoto);
            es.ModificareVoto(p.getPrenotazionePK(), aa);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informazioni");
            alert.setHeaderText(null);
            alert.setContentText("Il voto è stata inserito");
            alert.show();
            try {
                Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/InserireVoto.fxml"))));
            } catch (IOException ex) {
                Logger.getLogger(InserireVotoController.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        table.setItems(data);

    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioProf.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
