package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Bejegyzes> bejegyzesekLista = new ArrayList<>();
        Bejegyzes b1 = new Bejegyzes("Szerző első", "Nagyon sok tartalom");
        Bejegyzes b2 = new Bejegyzes("Szerző második", "Annál is több tartalom");
        bejegyzesekLista.add(b1);
        bejegyzesekLista.add(b2);

    }
}
