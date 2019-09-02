package views;

import connessione_al_database.MyDB;
import entità.Appello;
import entità.Docente;
import entità.Insegnamento;
import entità.Prenotazione;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import servizio.ButtonCellPianoSt;
import servizio.Service;

public class VotoEsameController implements Initializable {

    int b = 0;
    @FXML
    private TableView<Prenotazione> table;
    @FXML
    private TableColumn<Prenotazione, String> nomMaiere;
    @FXML
    private TableColumn<Prenotazione, String> date;
    @FXML
    private TableColumn<Prenotazione, String> nomProf;
    @FXML
    private TableColumn<Prenotazione, String> note;

    public ObservableList<Prenotazione> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Prenotazione, String> etat;
    Prenotazione prepe = new Prenotazione();

    List<Prenotazione> listM = new ArrayList<>();
    @FXML
    private Label labelMoyene;
    @FXML
    private PieChart statEtudiant;
    ObservableList<PieChart.Data> stat = FXCollections.observableArrayList();

    ArrayList<String> libelle = new ArrayList<>();
    ArrayList<Integer> quantiteDispo = new ArrayList<>();
    @FXML
    private BarChart<?, ?> barStat;
    @FXML
    private NumberAxis barY;
    @FXML
    private CategoryAxis barX;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelMoyene.setVisible(false);
        StatFunction();
        barFunction();
        try {
            Service es = new Service();

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from prenotazione  where voto != -1  and idStudente =" + LoginMemberController.getIdCnx() + "");

            while (rest.next()) {

                data.add(new Prenotazione(rest.getInt(1), rest.getInt(2), rest.getInt(3), rest.getString(4), rest.getString(5)));
                prepe.setStato(rest.getString(5));
                listM.add(prepe);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Appello.class.getName()).log(Level.SEVERE, null, ex);
        }

        nomMaiere.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                Insegnamento u = new Insegnamento();
                Service us = new Service();

                u = us.getMateriaByIdAppello(param.getValue().getAppello());
                return new SimpleStringProperty(u.getNome());
            }
        });

        nomProf.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                Docente u = new Docente();
                Service us = new Service();

                u = us.getProfByIdAppello(param.getValue().getAppello());
                return new SimpleStringProperty(u.getNome());
            }
        });

        date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                Appello u = new Appello();
                Service us = new Service();

                u = us.getAppelloById(param.getValue().getAppello());
                return new SimpleStringProperty(u.getDate().toString());
            }
        });

        note.setCellValueFactory(new PropertyValueFactory<>("voto"));
        etat.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prenotazione, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prenotazione, String> param) {
                String msg = "";
                if (Integer.parseInt(param.getValue().getVoto()) < 18) {
                    msg = "Rifiutato";
                } else {
                    msg = "Accettato";
                }
                return new SimpleStringProperty(msg);
            }
        });
// etat.setCellValueFactory(new PropertyValueFactory<>("stato"));
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

    @FXML
    private void DoThat(ContextMenuEvent event) {
        //  System.out.println(table.getSelectionModel().getSelectedItem().toString());

        Prenotazione p = table.getSelectionModel().getSelectedItem();

        final ContextMenu contextMenu = new ContextMenu();

        MenuItem Accepter = new MenuItem("Accettare");
        MenuItem refuser = new MenuItem("Rifiutare");

        if (p.getStato().equals("In Corso")) {
            contextMenu.getItems().add(Accepter);
            contextMenu.getItems().add(refuser);
        }
        if (p.getStato().equals("Rifiutato")) {
            contextMenu.getItems().remove(refuser);
            // contextMenu.getItems().add(Accepter);
        }
        if (p.getStato().equals("Accettato")) {
            contextMenu.getItems().add(refuser);
        }

        table.setContextMenu(contextMenu);

        Service l = new Service();

        Accepter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                l.ModificareStatoAccettato(p.getPrenotazionePK());
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informazioni");
                    alert.setHeaderText(null);
                    alert.setContentText("Il voto è stato confermato con successo");
                    alert.show();
                    Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/VotoEsame.fxml"))));
                } catch (IOException ex) {
                    Logger.getLogger(ButtonCellPianoSt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        refuser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                l.ModificareStato(p.getPrenotazionePK());
                try {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Informazioni");
                    alert.setHeaderText(null);
                    alert.setContentText("Il voto è stato rifiutata con successo");
                    alert.show();
                    Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/VotoEsame.fxml"))));
                } catch (IOException ex) {
                    Logger.getLogger(ButtonCellPianoSt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    private void moyenneEtudiant(ActionEvent event) {
        List<Prenotazione> list = new ArrayList<>();
        Service l = new Service();
        list = l.getAllPrenotazione();
        double moyenne = 0;
        double somme = 0;
        double sommeCoeff = 0;
        for (Prenotazione pre : list) {
            int coeff = l.getMateriaByIdAppello(pre.getAppello()).getCfu();
            sommeCoeff += coeff;
            somme = (somme) + (Double.parseDouble(pre.getVoto()) * coeff);
        }
        moyenne = somme / sommeCoeff;

        labelMoyene.setText("la tua media è : " + moyenne);
        labelMoyene.setVisible(true);

    }

    void StatFunction() {
        try {

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select stato , voto from prenotazione GROUP BY stato");

            while (rest.next()) {
                libelle.add(rest.getString("stato"));
                quantiteDispo.add(rest.getInt("voto"));
                stat.add(new PieChart.Data(rest.getString("stato"), rest.getInt("voto")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotoEsameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        statEtudiant.setAnimated(true);

        statEtudiant.maxHeight(1000);
        statEtudiant.setData(stat);

    }

    void barFunction() {

        try {

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select i.nome , p.voto from prenotazione p JOIN insegnamento i WHERE p.voto != -1 and i.codice =(select a.insegnamento_codice from appello a where a.id = p.idAppello ) and p.idStudente =" + LoginMemberController.getIdCnx() + "");

            while (rest.next()) {
                XYChart.Series set1 = new XYChart.Series<>();
                set1.getData().add(new XYChart.Data(rest.getString(1), rest.getInt(2)));
                barStat.getData().addAll(set1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotoEsameController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
