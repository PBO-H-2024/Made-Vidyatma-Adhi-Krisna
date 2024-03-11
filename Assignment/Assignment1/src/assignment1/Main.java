/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment1;
import java.util.Scanner;

import bangunRuang.LimasSegitiga;
import bangunRuang.Tabung;

/**
 *
 * @author ASUS
 */
public class Main {
    /**
     * @param args the command line arguments
     * @throws InterruptedException 
     */

    static void mainMenu(){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        System.out.println("Main Menu");
        System.out.println("1. Tabung");
        System.out.println("2. Limas Segitiga");
        System.out.println("0. Exit Program");
        System.out.print("Pilih : ");
    }
    
    @SuppressWarnings("resource")
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mainMenu();
            int pilih = scanner.nextInt();
            switch (pilih) {
                case 0: 
                    System.out.println("Exiting Program...");
                    Thread.sleep(1500);    
                    System.exit(0);
                case 1:
                    System.out.println("\nPROGRAM HITUNG TABUNG");
                    System.out.print("Input Tinggi Tabung : ");
                    int tinggi = scanner.nextInt();
                    System.out.print("Input Jari-Jari Tabung : ");
                    int jari = scanner.nextInt();
                    Tabung tabung = new Tabung(tinggi, jari);
                    System.out.printf("\nVolume Tabung : " + "%.2f", tabung.volume());
                    System.out.printf("\nLuas Permukaan Tabung : " +  "%.2f", tabung.luasPermukaan());
                    System.out.println("a");
                    break;
                case 2:
                    System.out.println("\nPROGRAM LIMAS SEGITIGA");
                    System.out.print("Input Alas Segitiga : ");
                    int alas = scanner.nextInt();
                    System.out.print("Input Tinggi Segitiga : ");
                    int tinggi_segitiga = scanner.nextInt();
                    System.out.print("Input Tinggi Limas : ");
                    int tinggi_limas = scanner.nextInt();
                    LimasSegitiga limas = new LimasSegitiga(tinggi_limas, alas, tinggi_segitiga);
                    System.out.println("Volume Limas : " + limas.volume());
                    System.out.printf("Luas Permukaan Limas : " + limas.luasPermukaan());
                    break;
                default:
                    System.out.println("Invalid. Input Again");
                    break;
            }
            System.out.print("\n\nLoading.");
            Thread.sleep(500);    
            System.out.print(".");
            Thread.sleep(500);    
            System.out.println(".");
            Thread.sleep(1000);    
            System.out.print("Press Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
            
        }
       
    }
    
}
