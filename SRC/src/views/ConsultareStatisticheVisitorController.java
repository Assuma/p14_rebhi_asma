package views;

import connessione_al_database.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * 
 * @author assma
 */

/**
 *Consultare la statistica dai visitors 
 */

public class ConsultareStatisticheVisitorController implements Initializable {

    @FXML
    private PieChart pieChart;
//    @FXML
//    private BarChart<?, ?> barChart;

    ObservableList<PieChart.Data> stat = FXCollections.observableArrayList();

    ArrayList<String> libelle = new ArrayList<String>();
    ArrayList<Integer> quantiteDispo = new ArrayList<Integer>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pieChartFunction();
        //barchartFunction();
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
    //Rappresentare il Pie Chart raggrouppata dagli anni di studi  
    void pieChartFunction() {
        try {

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select annoDiStudi , count(*) from insegnamento GROUP BY annoDiStudi");

            while (rest.next()) {
                libelle.add(rest.getString("annoDiStudi"));
                quantiteDispo.add(rest.getInt(2));
                stat.add(new PieChart.Data(rest.getString("annoDiStudi"), rest.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotoEsameController.class.getName()).log(Level.SEVERE, null, ex);
        }

        pieChart.setAnimated(true);

        pieChart.maxHeight(1000);
        pieChart.setData(stat);
    }

//    void barchartFunction() {
//
//        try {
//
//            MyDB myDB = MyDB.getInstance();
//            Statement stm = myDB.getConnexion().createStatement();
//            ResultSet rest = stm.executeQuery("select i.nome , count(*) from prenotazione p JOIN insegnamento i WHERE  p.voto > 18 and i.codice =(select a.insegnamento_codice from appello a where a.id = p.idAppello )");
//            XYChart.Series set1 = new XYChart.Series<>();
//            List<XYChart.Series> listSet = new ArrayList<>();
//            while (rest.next()) {
//                set1.getData().add(new XYChart.Data(rest.getString(1), rest.getInt(2)));
//                listSet.add(set1);
//            }
//            for (XYChart.Series s : listSet) {
//                barChart.getData().addAll(s);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(VotoEsameController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

}
