/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw;

import java.net.URL;
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
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Login(ActionEvent event) {
    }

    @FXML
    private void SignUp(ActionEvent event) {
    }
    
}
