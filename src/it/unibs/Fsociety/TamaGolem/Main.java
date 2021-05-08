package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int numero_elementi = 3;

        Elemento elemento_richiamo = new Elemento("richiamo");
        HashMap<Integer, Elemento> hashMapRichiamo = new HashMap<Integer, Elemento>();
        Equilibrio equilibrio = new Equilibrio(hashMapRichiamo);

        for (int i=0; i<10; i++){
            equilibrio = equilibrio.genera_equilibrio(numero_elementi);
            System.out.println("Elementi nuova partita:");
            for (int j = 0; j<equilibrio.getElementi_equilibrio().size(); j++){
                System.out.println(equilibrio.getElementi_equilibrio().get(j).getNome());
            }
        }

        /*// crazione dell'oggetto equilibrio che ti serve per richimare il metodo, che non è static
        Elemento elemento_di_richiamo = new Elemento ("richiamo");

        //  crazione del nuovo equlibrio
        HashMap<Integer, Elemento> equilibrio = new HashMap<>();
        /*Ciclo for che esegue il test della selezione degli elementi per più partite.
        * ELIMINARE ALLA CONCLUSIONE DELLE PROVE * /



        for (int j=0; j<10; j++) {
            System.out.println("Nuova prova del metodo");
            equilibrio.putAll(elemento_di_richiamo.inizializzaElementiEquilibrio(numero_elementi));

            for (int i = 0; i < equilibrio.size(); i++) {
                System.out.println(equilibrio.get(i).getNome());
            }
            System.out.print("\n");
            equilibrio.clear();
        }*/




    }
}
