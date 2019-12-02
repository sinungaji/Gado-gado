package id.ac.ukdw.rememberme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javax.swing.JOptionPane.showMessageDialog;

public class ConnectionDB {
    public static Connection Connector(){ 
            Connection conn =null;
        try {
            conn =DriverManager.getConnection("jdbc:sqlite:rplDB.db");
           
        } catch (SQLException e) {
            showMessageDialog(null,e.getMessage());
            
        }
        return conn;
    }
}