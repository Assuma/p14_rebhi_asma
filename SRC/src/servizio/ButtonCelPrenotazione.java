package servizio;

import com.sun.prism.impl.Disposer;
import entità.Appello;
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

public class ButtonCelPrenotazione extends TableCell<Disposer.Record, Boolean> {

    final Button cellButton = new Button("prenotare");

    public ButtonCelPrenotazione() {

        //Action when the button is pressed
        cellButton.setOnAction((ActionEvent t) -> {
            // get Selected Item
            Appello prodcourant = (Appello) ButtonCelPrenotazione.this.getTableView().getItems().get(ButtonCelPrenotazione.this.getIndex());
            Service l = new Service();

            l.PrenotareEsame(prodcourant.getId());

//  l.getMatiere(prodcourant);
            AnchorPane pane = new AnchorPane();
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informazioni");
                alert.setHeaderText(null);
                alert.setContentText("La tua prenotazione è stata confermata con successo");
                alert.show();
                Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/reserverExamen.fxml"))));
            } catch (IOException ex) {
                Logger.getLogger(ButtonCellPianoSt.class.getName()).log(Level.SEVERE, null, ex);
            }

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
