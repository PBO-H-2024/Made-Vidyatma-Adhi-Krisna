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
                    break;
                case 2:
                    Boolean invalid = true;
                    while (invalid) {
                        System.out.println("1. Segitiga Sama Sisi");
                        System.out.println("2. Segitiga Sama Kaki");
                        System.out.println("3. Segitiga Sembarang");
                        System.out.print("Pilih : ");
                        int pilihS = scanner.nextInt();
                        if(pilihS == 1){
                            System.out.println("\nPROGRAM LIMAS SEGITIGA SAMA SISI");
                            System.out.print("Input Tinggi Limas : ");
                            int tinggi_limas = scanner.nextInt();
                            System.out.print("Input Sisi : ");
                            int sisi = scanner.nextInt();
                            LimasSegitiga segitigaSisi = new LimasSegitiga(sisi, sisi, sisi, tinggi_limas);
                            System.out.printf("\nVolume Limas : " + "%.2f", segitigaSisi.volume());
                            System.out.printf("\nLuas Permukaan Limas : " +  "%.2f", segitigaSisi.luasPermukaan());
                            invalid = false;
                        } 
                        else if(pilihS == 2){
                            System.out.println("\nPROGRAM LIMAS SEGITIGA SAMA KAKI");
                            System.out.print("Input Tinggi Limas : ");
                            int tinggi_limas = scanner.nextInt();
                            System.out.print("Input Kaki : ");
                            int kaki = scanner.nextInt();
                            System.out.print("Input Alas : ");
                            int alas = scanner.nextInt();
                            LimasSegitiga segitigaKaki = new LimasSegitiga(kaki, kaki, alas, tinggi_limas);
                            System.out.printf("\nVolume Limas : " + "%.2f", segitigaKaki.volume());
                            System.out.printf("\nLuas Permukaan Limas : " + "%.2f",  segitigaKaki.luasPermukaan());
                            invalid = false;
                        }
                        else if(pilihS == 3){
                            System.out.println("\nPROGRAM LIMAS SEGITIGA SEMBARANG");
                            System.out.println("Segitiga Sembarang");
                            System.out.print("Input Tinggi Limas : ");
                            int tinggi_limas = scanner.nextInt();
                            System.out.println("Input A");
                            int a = scanner.nextInt();
                            System.out.println("Input B");
                            int b = scanner.nextInt();
                            System.out.println("Input C");
                            int c = scanner.nextInt();
                            LimasSegitiga segitigaSembarang = new LimasSegitiga(a, b, c, tinggi_limas);
                            System.out.printf("\nVolume Limas : " + "%.2f", segitigaSembarang.volume());
                            System.out.printf("\nLuas Permukaan Limas : " + "%.2f",  segitigaSembarang.luasPermukaan());
                            invalid = false;
                        }
                        else{
                            System.out.println("Invalid. Input Again\n");
                            invalid = true;
                        }
                    }
            }
            System.out.print("\n\nPress Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
        }
    }
}
