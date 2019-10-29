package id.ac.ukdw.rememberme.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {


    public String getNamaPengguna() {
        return namaPengguna.get();
    }

    public void setNamaPengguna(String namaPengguna) {
        this.namaPengguna = new SimpleStringProperty(namaPengguna);
    }

    public String getKataSandi() {
        return kataSandi.get();
    }

    public void setKataSandi(String kataSandi) {
        this.kataSandi = new SimpleStringProperty(kataSandi);
    }

    public int getUmur() {
        return umur.get();
    }

    public void setUmur(int umur) {
        this.umur = new SimpleIntegerProperty(umur);
    }

    public int getBeratBadan() {
        return beratBadan.get();
    }

    public void setBeratBadan(int beratBadan) {
        this.beratBadan = new SimpleIntegerProperty(beratBadan);
    }

    public int getTinggiBadan() {
        return tinggiBadan.get();
    }

    public void setTinggiBadan(int tinggiBadan) {
        this.tinggiBadan = new SimpleIntegerProperty(tinggiBadan);
    }
    
    private SimpleStringProperty namaPengguna;
    private SimpleStringProperty kataSandi;
    private SimpleIntegerProperty umur;
    private SimpleIntegerProperty beratBadan;
    private SimpleIntegerProperty tinggiBadan;
    
    public User() {
        this("","", 0,0,0);
    }
    
    public User(String isbn, String kataSandi, int umur,
            int beratBadan, int tinggiBadan) {
        this.namaPengguna = new SimpleStringProperty(isbn);
        this.kataSandi = new SimpleStringProperty(kataSandi);
        this.umur = new SimpleIntegerProperty(umur);
        this.beratBadan = new SimpleIntegerProperty(beratBadan);
        this.tinggiBadan = new SimpleIntegerProperty(tinggiBadan);
    }
    
    @Override
    public String toString() {
        return this.getNamaPengguna() + " " + getKataSandi();
    }
}
