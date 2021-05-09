package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Equilibrio {

    private HashMap<Integer, Elemento> elementi_equilibrio;
    private Grafo interazione_elementi;

    public Equilibrio(HashMap<Integer, Elemento> elementi_equilibrio) {
        this.elementi_equilibrio = elementi_equilibrio;
    }

    public Equilibrio() {}

    public Grafo getInterazione_elementi() {
        return interazione_elementi;
    }

    public HashMap<Integer, Elemento> getElementi_equilibrio() {
        return elementi_equilibrio;
    }

    public void setInterazione_elementi(Grafo interazione_elementi) {
        this.interazione_elementi = interazione_elementi;
    }

    public Equilibrio genera_equilibrio(int numero_elementi) {

        //Creazione dell'oggetto Elemento necessario per richimare il metodo di creazione dell'equilibrio
        Elemento elemento_di_richiamo = new Elemento();

        //Creazione del nuovo equilibrio e inserimento degli elementi
        Equilibrio equilibrio_partita = new Equilibrio(elemento_di_richiamo.inizializzaElementiEquilibrio(numero_elementi));

        //Creazione grafo associato agli elementi dell'equilibrio creato
        equilibrio_partita.interazione_elementi = new Grafo(numero_elementi);

        //Genera le interazioni tra gli elementi dell'equilibrio
        equilibrio_partita.interazione_elementi.imposta_interazione_elementi();

        return equilibrio_partita;
    }
}
