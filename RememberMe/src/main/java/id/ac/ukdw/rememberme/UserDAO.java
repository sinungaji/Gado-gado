package id.ac.ukdw.rememberme;

import id.ac.ukdw.rememberme.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    Connection con;
    public UserDAO () {
        con = ConnectionDB.Connector();
        if (con == null) {
        System.out.println("connection not successful");
        System.exit(1);}
    }
     
    public boolean isDbConnected() {
        try {
            return !con.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean dbLogin(String namaPengguna, String kataSandi) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM pengguna where namaPengguna = ? and kataSandi = ?";
        try {    
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, namaPengguna);
            preparedStatement.setString(2, kataSandi);
    
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
               return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            preparedStatement.close();
            rs.close();
        }
    }
}
