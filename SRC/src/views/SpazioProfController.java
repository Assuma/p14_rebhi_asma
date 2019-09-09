package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author assma
 */

/**
 *Presentare lo spazio per i docenti e i suoi differenti funzionalita' chi puo' fare
 */

public class SpazioProfController implements Initializable {
   /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    //andare all'interfaccia per aggiungere un appello 
    @FXML
    private void ajouterAppel(ActionEvent event) throws IOException {
          Parent page1 = FXMLLoader.load(getClass().getResource("/views/AggiungereAppello.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
  
   //andare all'interfaccia per inserire i voti 
    @FXML
    private void AjouterNote(ActionEvent event) throws IOException {
         Parent page1 = FXMLLoader.load(getClass().getResource("/views/InserireVoto.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
