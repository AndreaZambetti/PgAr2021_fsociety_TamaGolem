package it.unibs.Fsociety.TamaGolem;

import java.util.HashMap;

public class Equilibrio {

    private HashMap<Integer, Elemento> elementi_equilibrio;

    public Equilibrio(HashMap<Integer, Elemento> elementi_equilibrio) {
        this.elementi_equilibrio = elementi_equilibrio;
    }

    public Equilibrio() { }

    public HashMap<Integer, Elemento> getElementi_equilibrio() {
        return elementi_equilibrio;
    }

    public Equilibrio genera_equilibrio(int numero_elementi){

        //crazione dell'oggetto Elemento necessario per richimare il metodo di creazione dell'equilibrio
        Elemento elemento_di_richiamo = new Elemento();

        Equilibrio equilibrio_partita = new Equilibrio(elemento_di_richiamo.inizializzaElementiEquilibrio(numero_elementi));

        return equilibrio_partita;
    }
}
