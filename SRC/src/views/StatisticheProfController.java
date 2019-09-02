/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import connessione_al_database.MyDB;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
 * FXML Controller class
 *
 * @author marwe
 */
public class StatisticheProfController implements Initializable {

    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private PieChart pieChart;
ObservableList<PieChart.Data> stat = FXCollections.observableArrayList();

    ArrayList<String> libelle = new ArrayList<String>();
    ArrayList<Integer> quantiteDispo = new ArrayList<Integer>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {

            MyDB myDB = MyDB.getInstance();
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select i.nome , count(u.listInsegnamento_codice) from insegnamento i JOIN insegnamento_utente u JOIN appello a WHERE u.listInsegnamento_codice = i.codice AND a.insegnamento_codice=i.codice AND a.docente_matricola="+LoginMemberController.getIdCnx()+" GROUP BY i.codice");

            while (rest.next()) {
                XYChart.Series set1 = new XYChart.Series<>();
                set1.getData().add(new XYChart.Data(rest.getString(1), rest.getInt(2)));             
                barChart.getData().addAll(set1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VotoEsameController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
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

    @FXML
    private void retour(ActionEvent event) throws IOException {
          Parent page1 = FXMLLoader.load(getClass().getResource("/views/SpazioProf.fxml"));
            Scene scene = new Scene(page1);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
    }
    
}
