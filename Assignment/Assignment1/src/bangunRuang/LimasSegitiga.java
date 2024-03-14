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
public class LimasSegitiga extends Segitiga implements HitungRuang{
    double tinggi_limas, luasPermukaanTegak;
    public LimasSegitiga(double a, double b, double alas, double t) {
        super(a, b, alas);
        this.tinggi_limas = t;
        System.out.println("\nOUTPUT");
        System.out.println("Tinggi Segitiga : " + getTinggi());
        System.out.printf("Luas Segitiga : " + "%.2f",hitungLuas());
        System.out.printf("\nKeliling Segitiga : " + "%.2f",hitungKeliling());
    }
    public double volume(){
        return (hitungLuas() * tinggi_limas) / 3;
    }
    public double luasPermukaan(){
        luasPermukaanTegak = hitungLuas() * 3 ;
        return luasPermukaanTegak + hitungLuas();
    }
}
