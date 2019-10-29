package id.ac.ukdw.rememberme.dao;

import id.ac.ukdw.rememberme.dbConnect.ConnectionDB;
import id.ac.ukdw.rememberme.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author budsus
 */
public class UserDAO {

    public static User LoginUser (String namaPengguna) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM pengguna WHERE namaPengguna='" + namaPengguna + "'";
        try {
            ResultSet rsUser = ConnectionDB.getInstance().dbExecuteQuery(selectStmt);
            User user = getUserFromResultSet(rsUser);
            return user;
        } catch (SQLException e) {
            System.out.println("Sedang mencari user dengan isbn " + namaPengguna  + ", error terjadi: " + e);
            throw e;
        }
    }
    
        private static User getUserFromResultSet(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            user = new User();
            user.setNamaPengguna(rs.getString("namaPengguna"));
            user.setKataSandi(rs.getString("kataSandi"));
        }
        return user;
    }



    public static void updateUser(String namaPengguna, User user) throws SQLException, ClassNotFoundException {
        String updateStmt = "UPDATE user SET namaPengguna='" + user.getNamaPengguna()+ "',"
                + "kataSandi = '" + user.getKataSandi()+ "', "
                + "umur = '" + user.getUmur() + "', "
                + "tinggiBadan = '" + user.getTinggiBadan() + "', "
                + "beratBadan = '" + user.getBeratBadan() + "' "
                + "WHERE namaPengguna='" + namaPengguna + "'";
        try {
            ConnectionDB.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void deleteEmpWithId(String namaPengguna) throws SQLException, ClassNotFoundException {
        String updateStmt = "DELETE FROM user WHERE namaPengguna='" + namaPengguna + "'";
        try {
            ConnectionDB.getInstance().dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            throw e;
        }
    }
}
