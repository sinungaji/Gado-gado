/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme;

import java.sql.PreparedStatement;

/**
 *
 * @author Windows
 */
public class UserLogin {
    public String namaPengguna;
    public String kataSandi;
    
    public UserLogin(String namaPengguna, String kataSandi){
        this.namaPengguna = namaPengguna;
        this.kataSandi = kataSandi;
    }
    
//    String query = "select * from pengguna where namaPengguna=? and kataSandi=?";
//    PreparedStatement stmt = con.prepareStatement(query);
//    //Parameters
//    stmt.setString(1, namaPengguna);
//    stmt.setString(2, kataSandi);
    
    
}
