package id.ac.ukdw.rememberme;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/rplUI.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/fxml/style.css");
        
        stage.setTitle("Remember Me 0.1 SuperBeta Version");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
