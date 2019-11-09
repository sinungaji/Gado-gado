package id.ac.ukdw.rememberme;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RplUIController implements Initializable {
    
    UserDAO database = new UserDAO();
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private Pane pnMax;
    @FXML
    private Label label;
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
    private void Login(ActionEvent event) throws IOException, SQLException {
        if(database.dbLogin(tfNamaPengguna.getText(), pfKataSandi.getText())){
            Stage stageUtama = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rplUI-Beranda.fxml"));
            Parent root1 = (Parent) loader.load();
            Scene scene = new Scene(root1);
            scene.getStylesheets().add("/styles/style.css");
            stageUtama.setScene(scene);
            stageUtama.show();
        } else{
            label.setText("Nama atau Kata Sandi anda salah");
        }
    } 
    
    public void SignUp(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/rplUI-pendaftaran.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (database.isDbConnected()) {
            label.setText("Connected");
        } else {
            label.setText("Not Connected");
        }
    }    
}

