/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.rememberme.alarm;

/**
 *
 * @author user
 */
public class Alarm {
    private int jam;
    private int menit;
    private int detik;
    
    public Alarm(int jam, int menit, int detik){
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
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

