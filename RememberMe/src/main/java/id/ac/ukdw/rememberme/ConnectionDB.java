package id.ac.ukdw.rememberme;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    public static Connection Connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn =DriverManager.getConnection("jdbc:sqlite:rplDB.db");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
            return null;
            // TODO: handle exception
        }
    }

    boolean dbLogin(String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}