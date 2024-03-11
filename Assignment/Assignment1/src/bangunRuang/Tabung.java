/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bangunRuang;

import bangunDatar.Lingkaran;

/**
 *
 * @author ASUS
 */
public class Tabung extends Lingkaran{
    double tinggi;
    public Tabung(double t, double r){
        super(r);
        this.tinggi = t;
        System.out.println("Tinggi Tabung : " + tinggi);
        System.out.println("Jari-Jari Tabung : " + jari);
        System.out.println("\nLuas Lingkaran : " + hitungLuas());
        System.out.printf("Keliling Lingkaran : " + "%.2f",hitungKeliling());
    }
    public double volume(){
        return hitungLuas() * tinggi;
    }
    public double luasPermukaan(){
        return hitungKeliling() * (jari + tinggi);
    }
    
}
