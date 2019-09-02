
package views;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainPageController implements Initializable {

    @FXML
    private Pane homePage;
    @FXML
    private Button voirstatistiqueUserB;
    @FXML
    private Button voirProgrammeB;
    @FXML
    private Button loginB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void voirstatistiqueUser(ActionEvent event) {
       try{
        Parent page1
                = FXMLLoader.load(getClass().getResource("/views/ConsultareStatisticheVisitor.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    catch (IOException ex

    
        ) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE,
                null, ex);
    }
       
       
       
}

    

    @FXML
        private void voirProgramme(ActionEvent event) {
            
            try{
        Parent page1
                = FXMLLoader.load(getClass().getResource("/views/ConsultareCorsi.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    catch (IOException ex

    
        ) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE,
                null, ex);
    }
    }

    @FXML
        private void login(ActionEvent event) {
            
             try{
        Parent page1
                = FXMLLoader.load(getClass().getResource("/views/LoginMember.fxml"));
        Scene scene = new Scene(page1);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    catch (IOException ex

    
        ) {
        Logger.getLogger(MainPageController.class.getName()).log(Level.SEVERE,
                null, ex);
    }
            
    }
    
}
