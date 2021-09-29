package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static FileReader fr;
    public static BufferedReader bf;


    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Szerző első", "Nagyon sok tartalom");
        Bejegyzes b2 = new Bejegyzes("Szerző második", "Annál is több tartalom");
        bejegyzesekLista.add(b1);
        bejegyzesekLista.add(b2);

        int db;
        System.out.print("Adj meg egy számot: ");
        db = sc.nextInt();

        for (int i = 0; i < db; i++) {
            System.out.print("Add meg a szarzőt: ");
            String szerzo = sc.next();
            System.out.print("Add meg a tartalomat: ");
            String tartalom = sc.next();
            bejegyzesekLista.add(new Bejegyzes(szerzo, tartalom));
        }
        beolvas("bejegyzesek.txt");
    }
    public static void beolvas(String fileName){
        try {
            fr = new FileReader(fileName);
            bf = new BufferedReader(fr);
            String sor = bf.readLine();
            while(sor != null){
                String[] adatok = sor.split(";");
                bejegyzesekLista.add(new Bejegyzes(adatok[0], adatok[1]));
                sor = bf.readLine();
            }
            bf.close();
            fr.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
