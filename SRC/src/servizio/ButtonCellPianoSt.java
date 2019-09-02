package servizio;

import com.sun.prism.impl.Disposer.Record;
import entità.Insegnamento;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.AnchorPane;


public class ButtonCellPianoSt extends TableCell<Record, Boolean> {

    final Button cellButton = new Button("Confermare");

    public ButtonCellPianoSt() {

        //Action when the button is pressed
        cellButton.setOnAction((ActionEvent t) -> {
            // get Selected Item
            Insegnamento prodcourant = (Insegnamento) ButtonCellPianoSt.this.getTableView().getItems().get(ButtonCellPianoSt.this.getIndex());
            //remove selected item from the table list
            System.out.println("ID du produit   " + prodcourant.getCodice());
            Service l = new Service();

            l.getMateria(prodcourant);
            AnchorPane pane = new AnchorPane();
            try {
                 Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informazioni");
        alert.setHeaderText(null);
        alert.setContentText("La materia è stata inserita nel tuo piano di studi");
        alert.show();
                Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/planEtudes.fxml"))));
            } catch (IOException ex) {
                Logger.getLogger(ButtonCellPianoSt.class.getName()).log(Level.SEVERE, null, ex);
            }

            // main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/modifprod.fxml"))));

            // main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/modifprod.fxml"))));
        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if (!empty) {
            setGraphic(cellButton);
        }
    }

}
