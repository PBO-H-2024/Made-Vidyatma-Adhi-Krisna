/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bangunDatar;

/**
 *
 * @author ASUS
 */
public class Segitiga implements HitungBidang{
    public double alas, tinggi_segitiga;
    public Segitiga(double a, double t){
        this.alas = a;
        this.tinggi_segitiga = t;
    }
    public double hitungLuas(){
        return alas * tinggi_segitiga * 0.5;
    }
    public double hitungKeliling(){
        double sisiMiring = Math.sqrt(((0.5) * alas * (0.5) * alas) + (tinggi_segitiga * tinggi_segitiga));
        return alas + tinggi_segitiga + sisiMiring;
    }
}
