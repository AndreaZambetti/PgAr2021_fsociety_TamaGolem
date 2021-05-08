package it.unibs.Fsociety.TamaGolem;

import java.util.HashMap;

public class Equilibrio {

    private HashMap<Integer, Elemento> elementi_equilibrio;

    /*public Equilibrio(String nome) {
        super(nome);
    }*/

    public Equilibrio(HashMap<Integer, Elemento> elementi_partita) {
        this.elementi_equilibrio = elementi_partita;
    }

    public HashMap<Integer, Elemento> getElementi_equilibrio() {
        return elementi_equilibrio;
    }

    public void setElementi_equilibrio(HashMap<Integer, Elemento> elementi_equilibrio) {
        this.elementi_equilibrio = elementi_equilibrio;
    }

    public Equilibrio genera_equilibrio(int numero_elementi){

        // crazione dell'oggetto equilibrio che ti serve per richimare il metodo, che non è static
        Elemento elemento_di_richiamo = new Elemento ("richiamo");

        Equilibrio equilibrio_partita = new Equilibrio(elemento_di_richiamo.inizializzaElementiEquilibrio(numero_elementi));

        return equilibrio_partita;
    }
}
