/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bangunDatar;
/**
 *
 * @author ASUS
 */
public class Lingkaran implements HitungBidang{
    public double jari;
    static double phi = 3.14;
    public Lingkaran(double r){
        this.jari = r;
    }
    public double hitungLuas(){
        return phi * jari * jari;
    }
    public double hitungKeliling(){
        return (2 * phi * jari);
    }
}
