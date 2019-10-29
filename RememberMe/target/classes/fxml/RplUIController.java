/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import id.ac.ukdw.rememberme.dbConnect.ConnectionDB;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Windows
 */
public class RplUIController implements Initializable {

    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane pnMax;
    @FXML
    private Label lbl_close;
    @FXML
    private TextField tfNamaPengguna;
    @FXML
    private PasswordField pfKataSandi;
    @FXML
    private Button btnMasuk;
    @FXML
    private Hyperlink hplDaftar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
        Connection connection = ConnectionDB.getInstance().getConnection();
       try{
           String namaPengguna = tfNamaPengguna.getText();
           String kataSandi = pfKataSandi.getText();
           Statement statement = connection.createStatement();
           int status = statement.executeUpdate("insert into pengguna (namaPengguna, kataSandi)" + "values('" + namaPengguna + "','" + kataSandi + "')");
           if (status > 0){
               System.out.println("pengguna terdaftar");
           }
       }  catch(SQLException e){
               e.printStackTrace();
           }
    }
    
}
