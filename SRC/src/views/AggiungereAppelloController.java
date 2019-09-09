package views;

import connessione_al_database.MyDB;
import entità.Appello;
import entità.Insegnamento;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import servizio.Service;

/**
 * 
 * @author assma
 */

/**
 *Aggiungere/Creare un appello per un esame mettendo gli informazioni necessari per l'esame
 * (l'aula, la data, la durata, la materia e la descrizione)
 */


public class AggiungereAppelloController implements Initializable {

    @FXML
    private TextField aula;
    @FXML
    private DatePicker data;
    @FXML
    private TextField description;
    @FXML
    private TextField durata;
    @FXML
    private ComboBox<String> materia;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //estrarre i nomi degli insegnamenti per usarli nel camboBox
        try
        {
            
        MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
                ResultSet rest = stm.executeQuery("select * from insegnamento");

            
            while (rest.next()) {
               materia.getItems().add(rest.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Insegnamento.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
     
    }
   //Tornare nell'interfaccia precedente
    @FXML
    private void Back(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioProf.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
   //inserire gli informazioni per aggiungere un nuovo appello
    @FXML
    private void AggiungiEsame(ActionEvent event) throws ParseException {
        Appello app = new Appello();
        Service es = new Service();
        app.setAula(aula.getText());
     
        String date = this.data.getValue().toString();
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
java.util.Date dateStr = formatter.parse(date);
java.sql.Date dateDB = new java.sql.Date(dateStr.getTime());

         app.setDate(dateDB);

        app.setDescription(description.getText());
        app.setDurata(Double.parseDouble(durata.getText()));
        app.setInsegnamento(es.getIDMateriaByNome(materia.getValue()));
        app.setDocente(LoginMemberController.getIdCnx());
        es.AggiungereAppello(app);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informazioni");
        alert.setHeaderText(null);
        alert.setContentText("Appello aggiunto con successo");
        alert.show();
    }

}
