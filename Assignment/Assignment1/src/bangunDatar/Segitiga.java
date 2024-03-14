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
    public double a,b,c;
    public double semiParameter; // s untuk menggunakan rumus Heron
    public Segitiga(double a, double b, double c){ // c adalah alas
        this.a = a;
        this.b = b;
        this.c = c;
        
    }
    public double getTinggi() {
        return Math.sqrt( (a*a) - (c/2)*(c/2) ); //get tinggi dengan rumus pythagoras
    }
    public double hitungLuas(){
        return(c * getTinggi()) / 2; // ingat c adalah alas
    };
    public double hitungKeliling(){
        return c + a + b;
    }

    public double luasSegitigaSembarang(){
        semiParameter = hitungKeliling() / 2;
        return Math.sqrt(semiParameter * (semiParameter - a) * (semiParameter - b) * (semiParameter - c));
    }
}
