package views;

import entità.Studente;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import servizio.Service;

/**
 * 
 * @author assma
 */

/**
 *Presentare lo spazio per gli studenti e i suoi differenti funzionalita' chi puo' fare
 */

public class SpazioStudenteController implements Initializable {

    @FXML
    private Button modifierProfiB;
    @FXML
    private Button planEtudesB;
    @FXML
    private Button noteExamenB;
    @FXML
    private Button reserverExamenB;
    @FXML
    private Label labelH;

    Service etudiantService = new Service();
    Studente etudiant;
    @FXML
    private Button logOutB;

    public SpazioStudenteController() throws SQLException {
        this.etudiant = etudiantService.getStudentById(LoginMemberController.getIdCnx());
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        labelH.setText("Benvenuto "+etudiant.getNome());
    }    
    //andare all'interfaccia per modificare i suoi dati
    @FXML
    private void modifierProfiB(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/ModificareAnagrafica.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    //andare all'interfaccia per compilare il suo  piano di studio
    @FXML
    private void planEtudes(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/PianoDiStudio.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    //andare all'interfaccia per accettare/rifiutare un voto  
    @FXML
    private void noteExamen(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/VotoEsame.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }
    //andare all'interfaccia per prenotare per un esame 
    @FXML
    private void reserverExamenB(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/PrenotareEsame.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }
    //Logout e tornare alla pagina precedente
    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/LoginMember.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
