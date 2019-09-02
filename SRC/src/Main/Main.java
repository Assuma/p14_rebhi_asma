package Main;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    private Stage stage;
    private static Main instance;
    private Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        //   Parent root = FXMLLoader.load(getClass().getResource("/views/MainPage.fxml"));

        
        this.stage = stage;
        stage.setScene(this.scene);
        stage.setWidth(950);
        stage.setHeight(700);
        stage.centerOnScreen();

        stage.show();
    }

    public Main() throws IOException, InterruptedException {
        instance = this;
        scene = new Scene(FXMLLoader.load(getClass().getResource("/views/MainPage.fxml")));

    }

    public static Main getInstance() {
        return instance;
    }

    public Stage getStage() {
        return stage;
    }

    public void changescene(Scene scene) {
        this.scene = scene;
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

   
    public static void main(String[] args) {
        launch(args);
    }

}
