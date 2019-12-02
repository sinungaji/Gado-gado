/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme.model;



/**
 *
 * @author ASUS
 */
public class Makanan {

    /**
     * @return the idMakanan
     */
    public Integer getIdMakanan() {
        return idMakanan;
    }

    /**
     * @param idMakanan the idMakanan to set
     */
    public void setIdMakanan(Integer idMakanan) {
        this.idMakanan = idMakanan;
    }

    /**
     * @return the namaMakanan
     */
    public String getNamaMakanan() {
        return namaMakanan;
    }

    /**
     * @param namaMakanan the namaMakanan to set
     */
    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    /**
     * @return the berat
     */
    public String getBerat() {
        return berat;
    }

    /**
     * @param berat the berat to set
     */
    public void setBerat(String berat) {
        this.berat = berat;
    }

    /**
     * @return the kalori
     */
    public String getKalori() {
        return kalori;
    }

    /**
     * @param kalori the kalori to set
     */
    public void setKalori(String kalori) {
        this.kalori = kalori;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
     
    private Integer idMakanan;
    private String namaMakanan;
    private String berat;
    private String kalori;
    private String unit;
    
    public Makanan(){
        this(0,"","","","");
    }
    
    public Makanan(Integer idMakanan, String namaMakanan, String berat, String kalori, String unit){
       this.idMakanan = idMakanan;
       this.namaMakanan = namaMakanan;
       this.berat = berat;
       this.kalori = kalori;
       this.unit = unit;
               
    }

    public Makanan(String string, String string0, String string1, String string2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString(){
        return this.getIdMakanan()+" " + getNamaMakanan();
    }
}
