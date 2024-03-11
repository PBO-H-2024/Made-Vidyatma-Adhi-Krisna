/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bangunRuang;

import bangunDatar.Segitiga;

/**
 *
 * @author ASUS
 */
public class LimasSegitiga extends Segitiga{
    double tinggi_limas;
    public LimasSegitiga(double t, double a, double tinggi_segitiga){
        super(a,tinggi_segitiga);
        this.tinggi_limas = t;
        System.out.println("Alas Segitiga : " + alas);
        System.out.println("Tinggi Segitiga : " + tinggi_segitiga);
        System.out.println("Tinggi Limas Segitiga : " + tinggi_limas);
        System.out.println("\nLuas Segitiga : " + hitungLuas());
        System.out.println("Keliling Segitiga : " + hitungKeliling());
    }
    public double volume(){
        return  (hitungLuas() * tinggi_limas) / 3;
    }
    public double luasPermukaan(){
        return (hitungLuas() + 3 * 0.5 * alas * tinggi_limas);
    }
}
