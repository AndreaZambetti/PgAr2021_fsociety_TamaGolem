package it.unibs.Fsociety.TamaGolem;

import java.util.HashMap;

public class Equilibrio{

    private HashMap<Integer, Elemento> elementi_partita;

    public HashMap<Integer, Elemento> getElementi_partita() {
        return elementi_partita;
    }

    public void setElementi_partita(HashMap<Integer, Elemento> elementi_partita) {
        this.elementi_partita = elementi_partita;
    }

    public Equilibrio genera_equilibrio(int numero_elementi){

        Equilibrio equilibrio_partita = new Equilibrio();

        //equilibrio_partita.elementi_partita.inizializzaElementiEquilibrio(numero_elementi);

        return equilibrio_partita;
    }
}
