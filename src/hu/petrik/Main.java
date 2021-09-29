package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    public static FileReader fr;
    public static BufferedReader bf;
    public static Random rnd = new Random();


    public static void main(String[] args) {
        Bejegyzes b1 = new Bejegyzes("Szerző első", "Nagyon sok tartalom");
        Bejegyzes b2 = new Bejegyzes("Szerző második", "Annál is több tartalom");
        bejegyzesekLista.add(b1);
        bejegyzesekLista.add(b2);

        int db;
        System.out.print("Adj meg egy számot: ");
        db = sc.nextInt();

        for (int i = 0; i < db; i++) {
            System.out.print("Add meg a szerzőt: ");
            String szerzo = sc.next();
            System.out.print("Add meg a tartalomat: ");
            String tartalom = sc.next();
            bejegyzesekLista.add(new Bejegyzes(szerzo, tartalom));
        }
        beolvas("bejegyzesek.txt");
        likeOsztas();

        System.out.println("Add meg mire írjam át a második bejegyzést: ");
        String modositottBejegyzes = sc.nextLine();
        bejegyzesekLista.get(1).setTartalom(modositottBejegyzes);

        kiiratas();

        System.out.printf("A legnépszerűbb bejegyzésen %d like van\n", legnepszerubb());

        String vanEHarmincotLike = harmincotnelTobbLike() ? "Van" : "Nincs";
        System.out.println(vanEHarmincotLike + " olyan bejegyzést ami 35-nél több likeot kapott.");

        System.out.println(tizenotnelKevesebbLike() + " db bejegyzést van ami 15-nél kevesebb likeot kapott.");

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

    public static void likeOsztas(){
        int bejegyzesekSzorzata = bejegyzesekLista.size() * 20;
        for (int i = 0; i < bejegyzesekSzorzata; i++) {
            bejegyzesekLista.get(rnd.nextInt(bejegyzesekLista.size())).like();
        }
    }

    public static void kiiratas(){
        for (Bejegyzes item : bejegyzesekLista) {
            System.out.println(item);
        }
    }

    public static int legnepszerubb(){
        int max = 0;
        for (Bejegyzes item : bejegyzesekLista) {
            if (item.getLikeok() > max){
                max = item.getLikeok();
            }
        }
        return max;
    }

    public static boolean harmincotnelTobbLike(){
        boolean van = false;
        for (Bejegyzes item : bejegyzesekLista) {
            if (item.getLikeok() > 35){
                van = true;
            }
        }
        return van;
    }

    public static int tizenotnelKevesebbLike(){
        int db = 0;
        for (Bejegyzes item : bejegyzesekLista) {
            if (item.getLikeok() < 15){
                db++;
            }
        }
        return db;
    }
}
