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
    double tinggi_limas;
    public LimasSegitiga(double a, double b, double c, double t) { // c adalah alas
        super(a, b, c);
        this.tinggi_limas = t;
        System.out.println("\nOUTPUT");
    }
    public double volume(){
        return (hitungLuas() * tinggi_limas) / 3;
    }
    public double luasPermukaan(){
        return hitungLuas() + (tinggi_limas/2) + (a+b+c); //luas alas + luas selubung
    }
    public double volumeLimasSembarang(){
        return (luasSegitigaSembarang() * tinggi_limas) / 3; //menggunakan luas yang pakai rumus heron karena tidak bisa pythagoras
    }
    public double luasPermukaanLimasSembarang(){
        return luasSegitigaSembarang() + ( (tinggi_limas/2) * (a+b+c) );
    }
}
