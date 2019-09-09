
package views;

import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import servizio.Service;


/**
 * 
 * @author assma
 */

/**
 *Classe per modificare i dati dello studente 
 */

public class ModificareAnagraficaController implements Initializable {

    @FXML
    private TextField cellulare;
    @FXML
    private TextField cognome;
    @FXML
    private TextField email;
    @FXML
    private TextField nome;
    @FXML
    private TextField indrizzo;
    @FXML
    private Button modifierB;
    @FXML
    private PasswordField password;
    @FXML
    private Button retourB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Service es = new Service();

        try {
            Studente etudiant = es.getStudentById(LoginMemberController.getIdCnx());
            cellulare.setText("" + etudiant.getCellulare());
            cognome.setText("" + etudiant.getCognome());
            email.setText("" + etudiant.getEmail());
            nome.setText("" + etudiant.getNome());
            indrizzo.setText("" + etudiant.getIndirizzo());
            password.setText("" + etudiant.getPassword());
           
           

        } catch (SQLException ex) {
            Logger.getLogger(ModificareAnagraficaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //confermare la modifica dei dati
    @FXML
    private void DoModifier(ActionEvent event) {
        Service es = new Service();
        Studente s = new Studente();
        s.setCellulare(cellulare.getText());
        s.setCognome(cognome.getText());
        s.setEmail(email.getText());
        s.setNome(nome.getText());
        s.setIndirizzo(indrizzo.getText());
        s.setPassword(password.getText());
        es.ModificareStudent(LoginMemberController.getIdCnx(), s);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("informazioni");
        alert.setHeaderText(null);
        alert.setContentText("il tuo profilo è cambiato con successo");
        alert.show();
    }
   
    //Tornare alla pagina precedente
    @FXML
    private void retour(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioStudente.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
