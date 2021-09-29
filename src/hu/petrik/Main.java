package hu.petrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
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


    }
}
