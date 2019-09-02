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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        labelH.setText("Benvenuto "+etudiant.getNome());
    }    

    @FXML
    private void modifierProfiB(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/ModificareAnagrafica.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    private void planEtudes(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/PianoDiStudio.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    private void noteExamen(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/VotoEsame.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    private void reserverExamenB(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/PrenotareEsame.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("/views/LoginMember.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
