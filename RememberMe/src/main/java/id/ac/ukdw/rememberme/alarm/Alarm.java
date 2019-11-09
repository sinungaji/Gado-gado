/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme.alarm;

import java.util.Calendar;

/**
 *
 * @author user
 */
public class Alarm {
    private int jam;
    private int menit;
    private int detik;
    //boleh diapus boleh di keep tapi jadi tampungan
    private Calendar a;         //pelajari di google
    //bikin class dao.java lagi
    
    public Alarm(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
        //cara masukin angka tadi ke java calendar
    }
    
    public void setJam(int jam){
        this.jam = jam;
    }
    public int getJam(){
        return this.jam;
    }
    public void setMenit(int menit){
        this.menit = menit;
    }
    public int getMenit(){
        return this.menit;
    }
    public void setDetik(int detik){
        this.detik = detik;
    }
    public int getDetik(){
        return this.detik;
    }
}

