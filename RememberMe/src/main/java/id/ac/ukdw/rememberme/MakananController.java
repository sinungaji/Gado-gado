/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme;

import id.ac.ukdw.rememberme.db.DBUtil;
import id.ac.ukdw.rememberme.db.MakananDAO;
import id.ac.ukdw.rememberme.model.Makanan;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author Stefanus
 */
public class MakananController implements Initializable {
    
    @FXML
    private TableView<Makanan> tableMakanan;
    
    @FXML
    private TableColumn<Makanan, Integer> colMknId;
    
    @FXML
    private TableColumn<Makanan, String> colMknName;
    
    @FXML
    private TableColumn<Makanan, String> colMknBerat;
    
    @FXML
    private TableColumn<Makanan, String> colKalori;
    
    @FXML
    private TableColumn<Makanan, String> colUnit;
    
    @FXML
    private TextField tfNamaMakanan;
  
    @FXML
    private TextField tfBerat;        

    @FXML
    private TextField tfKalori;
    
    @FXML
    private TextField tfUnit;

  @FXML
    private TextField srcUnit;

    @FXML
    private TextField srcKalori;
     @FXML
    private TextField srcBerat;

    @FXML
    private Button btnLoad;

    @FXML
    private TextField srcMakananId;

    @FXML
    private TextArea resultConsole;
    @FXML
    void insertMakanan(ActionEvent event) throws SQLException {
        String namaMakanan = tfNamaMakanan.getText();
        String berat = tfBerat.getText();
        String kalori = tfKalori.getText();
        String unit = tfUnit.getText();
        try{
            String sql="INSERT INTO makanan(namaMakanan, berat, kalori,unit) "
                    +"VALUES('"+namaMakanan+"','"+berat+"','"+kalori+"','"+unit+"')";
            
            
            Connection conn = ConnectionDB.Connector();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            tfNamaMakanan.setText("");
            tfBerat.setText("");
            tfKalori.setText("");
            tfUnit.setText("");
            showMessageDialog(null,"Berhasil");
            conn.close();
        }
        catch(SQLException e){
            showMessageDialog(null,e.getMessage());
        }
        

    }

 
    @FXML
    void updateMakanan(ActionEvent event) throws ClassNotFoundException, SQLException {
      try{
            MakananDAO.updateMakanan(Integer.parseInt(srcMakananId.getText()), srcBerat.getText(), srcKalori.getText(), srcUnit.getText());
            resultConsole.setText("Succses to Database Update");
        }catch(SQLException e){
            System.out.println("Error Updating"+e);
            e.printStackTrace();
            throw e;
        }
    }
    
    @FXML
    void searchMakanan(ActionEvent event) throws ClassNotFoundException, SQLException {
      
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colMknId.setCellValueFactory(new PropertyValueFactory("idMakanan"));
        colMknName.setCellValueFactory(new PropertyValueFactory("namaMakanan"));
        colMknBerat.setCellValueFactory(new PropertyValueFactory("berat"));
        colKalori.setCellValueFactory(new PropertyValueFactory("kalori"));
        colUnit.setCellValueFactory(new PropertyValueFactory("unit"));
        
        //ambil data dari database dan masukkan ke TableView
        ObservableList<Makanan> data;
        try {
            data = MakananDAO.searchMakanans();
            tableMakanan.setItems(data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MakananController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }    
    
}
