package views;

import connessione_al_database.MyDB;
import entità.Utente;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * 
 * @author assma
 */

/**
 *Classe per l'autenticazione degli studenti e dei docenti
 */
public class LoginMemberController implements Initializable {

    @FXML
    private PasswordField password;
    @FXML
    private Button loginP;

    @FXML
    private TextField login;
    private static int idCnx;

    public static int getIdCnx() {
        return idCnx;
    }

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    //L'autenticazione tramite email e la password dell'utente
    @FXML
    private void DoLogin(ActionEvent event) throws SQLException, IOException {

        MyDB myDB = MyDB.getInstance();
        Statement stm2 = myDB.getConnexion().createStatement();
        ResultSet rest2 = stm2.executeQuery("select * from utente where email = '" + login.getText() + "' and password ='" + password.getText() + "'");
        Utente user = new Utente();
        String annoST = "";
        while (rest2.next()) {
            annoST = rest2.getString(9);
            user.setMatricola(rest2.getInt(2));
            user.setCellulare(rest2.getString(3));
            user.setCognome(rest2.getString(4));
            user.setEmail(rest2.getString(5));
            user.setIndirizzo(rest2.getString(6));
            user.setNome(rest2.getString(7));
            user.setPassword(rest2.getString(8));
        }
        idCnx = user.getMatricola();
        //se l'attribute AnnoST e' pieno,visualizza l'interfaccia dello studente 
        if (login.getText().equals(user.getEmail()) && password.getText().equals(user.getPassword())) {
            if (annoST != null) {
                Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioStudente.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
        //se l'attribute AnnoST e' vuoto ,visualizza l'interfaccia del docente 
            } else {
                Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioProf.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            //visualizza un messaggio d'errore se i credenziali sono sbagliati
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("login o password non sono corretti !!!!!");
            alert.show();
        }

    }
    //Tornare alla pagina precedente(HomePage)
     @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/MainPage.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
