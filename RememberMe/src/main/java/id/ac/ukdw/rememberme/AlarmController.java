package id.ac.ukdw.rememberme;

import java.io.IOException;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class AlarmController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField tfJamPagi;

    @FXML
    private TextField tfJamSiang;

    @FXML
    private TextField txtJamMalam;

    @FXML
    private Button btnSetAlarm;

    @FXML
    private TextField tfMenitPagi;

    @FXML
    private TextField txtMenitSiang;

    @FXML
    private TextField txtMenitMalam;

    @FXML
    private Button next;

    @FXML
    private Button btnALarm;
    
    @FXML
    private void Next(ActionEvent event) throws IOException, SQLException {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Makanan.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    } 
    
}
