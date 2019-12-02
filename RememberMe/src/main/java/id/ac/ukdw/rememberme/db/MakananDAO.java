package id.ac.ukdw.rememberme.db;

import id.ac.ukdw.rememberme.ConnectionDB;
import id.ac.ukdw.rememberme.model.Makanan;
import java.sql.Connection;
//import ukdw.db.Makanan;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author budsus
 */
public class MakananDAO {

    public static Makanan searchMakanan(Integer idMakanan) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM makanan WHERE idMakanan='" + idMakanan + "'";
        try {
            ResultSet rsMakanan = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            Makanan makanan = getMakananFromResultSet(rsMakanan);
            return makanan;
        } catch (SQLException e) {
            System.out.println("Sedang mencari makanan dengan idMakanan " + idMakanan  + ", error terjadi: " + e);
            throw e;
        }
    }

    private static Makanan getMakananFromResultSet(ResultSet rs) throws SQLException {
        Makanan makanan = null;
        if (rs.next()) {
            makanan = new Makanan();
            makanan.setIdMakanan(rs.getInt("idMakanan"));
            makanan.setNamaMakanan(rs.getString("namaMakanan"));
            makanan.setBerat(rs.getString("berat"));
            makanan.setKalori(rs.getString("kalori"));
            makanan.setUnit(rs.getString("unit"));
        }
        return makanan;
    }

    public static ObservableList<Makanan> searchMakanans() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM makanan";
        try {
            ResultSet rsMakanan = DBUtil.getInstance().dbExecuteQuery(selectStmt);
            ObservableList<Makanan> makananList = getMakananList(rsMakanan);
            return makananList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
    }

    private static ObservableList<Makanan> getMakananList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<Makanan> makananList = FXCollections.observableArrayList();
        while (rs.next()) {
            Makanan makanan = new Makanan();
            makanan.setIdMakanan(rs.getInt("idMakanan"));
            makanan.setNamaMakanan(rs.getString("namaMakanan"));
            makanan.setBerat(rs.getString("berat"));
            makanan.setKalori(rs.getString("kalori"));
            makanan.setUnit(rs.getString("unit"));
            makananList.add(makanan);
        }
        return makananList;
    }

     public static void updateMakanan(int idMakanan, String berat, String kalori, String unit) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE makanan SET berat= '"+berat+"', kalori='"+kalori+"',unit='"+unit+"' where idMakanan = '"+idMakanan+"'";
         
        try{
          DBUtil.getInstance().dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Error Updating");
            e.printStackTrace();
            throw e;
        }
        
        
    }

    public static void deleteEmpWithId(String idMakanan) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM makanan WHERE idMakanan='" + idMakanan + "'";
        try {
            DBUtil.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
            
        }
        
    }

}
