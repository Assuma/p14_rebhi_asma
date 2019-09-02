package servizio;

import com.sun.prism.impl.Disposer;
import entità.Insegnamento;
import entità.Prenotazione;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.layout.AnchorPane;


public class ButtonCellRifiutare extends TableCell<Disposer.Record, Boolean> {

    final Button cellButton = new Button();

    public ButtonCellRifiutare(int a) {

        if (a == 2) {

            cellButton.setText("Accettare");
        }
        if (a == 1) {
            cellButton.setText("Rifiutare");
        }
        if (a == 3) {
            cellButton.setText("Voto Accettato");

        }
        //Action when the button is pressed
        cellButton.setOnAction((ActionEvent t) -> {
            // get Selected Item
            Prenotazione prodcourant = (Prenotazione) ButtonCellRifiutare.this.getTableView().getItems().get(ButtonCellRifiutare.this.getIndex());
            //remove selected item from the table list
            Service l = new Service();

            if (cellButton.getText().equals("Accettare")) {
                l.ModificareStatoAccettato(prodcourant.getPrenotazionePK());
            }

            if (cellButton.getText().equals("Rifiutare")) {
                l.ModificareStato(prodcourant.getPrenotazionePK());
            }
            if (cellButton.getText().equals("Voto Accettato")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informazioni");
                alert.setHeaderText(null);
                alert.setContentText("Hai già accettato il voto");
                alert.show();
            }

            AnchorPane pane = new AnchorPane();
            try {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informazioni");
                alert.setHeaderText(null);
                alert.setContentText("Il voto è insufficiente!");
                alert.show();
                Main.Main.getInstance().changescene(new Scene(FXMLLoader.load(getClass().getResource("/views/noteExamen.fxml"))));
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
