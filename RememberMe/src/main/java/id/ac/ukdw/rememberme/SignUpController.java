/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ASUS
 */
public class SignUpController implements Initializable{
      @FXML
    private BorderPane borderPane;

    @FXML
    private Pane bgPane;

    @FXML
    private TextField tfNamaDaftar;

    @FXML
    private TextField tfUmur;

    @FXML
    private PasswordField p;

    @FXML
    private ComboBox<String> tfJenisKelamin;
    
    @FXML
    private Label lblStatus;

    @FXML
    private Button btnLanjut;
    
    PreparedStatement preparedStatement;
    Connection connection;
    
    public SignUpController() {
        connection = (Connection) ConnectionDB.Connector();
    }
    ObservableList<String> data = FXCollections.observableArrayList("Laki-Laki","Perempuan");
    @Override
    public void initialize(URL location, ResourceBundle rb) {
    tfJenisKelamin.getItems().addAll("Laki-Laki", "Perempuan", "Other");
        tfJenisKelamin.getSelectionModel().select("Laki-Laki");
          
    }
    @FXML
    private void SaveData(ActionEvent event) throws IOException, SQLException  {
        //check if not empty
        if (tfNamaDaftar.getText().isEmpty() || tfUmur.getText().isEmpty() || p.getText().isEmpty()) {
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText("Enter all details");
        } else {
            Save();
            Stage stageUtama = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rplUI.fxml"));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            scene.getStylesheets().add("/styles/style.css");
            stageUtama.setScene(scene);
            stageUtama.show();
        }

    }
    
     private void ClearFields() {
        tfNamaDaftar.clear();
        tfUmur.clear();
    }
     
     private String Save() {

        try {
            String st = "INSERT INTO pengguna( namaPengguna, kataSandi, umur, jenisKelamin) VALUES (?,?,?,?)";
            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
            preparedStatement.setString(1, tfNamaDaftar.getText());
            preparedStatement.setString(2, p.getText());
            preparedStatement.setString(3, tfUmur.getText());
            preparedStatement.setString(4, tfJenisKelamin.getValue().toString());
            
            preparedStatement.executeUpdate();
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Added Successfully");

           
            //clear fields
            ClearFields();
            return "Success";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            lblStatus.setTextFill(Color.TOMATO);
            lblStatus.setText(e.getMessage());
            return "Exception";
        }
        
    }
   
    
     
}
