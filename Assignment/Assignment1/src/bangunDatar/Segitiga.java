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
    public double a,b,alas;
    public Segitiga(double a, double b, double alas){
        this.a = a;
        this.b = b;
        this.alas = alas;
        
    }
    public double getTinggi() {
        return Math.sqrt( (a*a) - (alas/2)*(alas/2) );
    }
    public double hitungLuas(){
        return(alas * getTinggi()) / 2;
    };
    public double hitungKeliling(){
        return alas + a + b;
    }
}
