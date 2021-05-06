package it.unibs.Fsociety.TamaGolem;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int numero_elementi = 9;


        // crazione del oggetto equilibrio che ti serve per richimare il metodo, che non e static
        Elemento elemento = new Elemento ("fuoco");

        //  crazione del nuovo equlibrio
        HashMap<Integer, Elemento> equilibrio = new HashMap<>();
        /*Ciclo for che esegue il test della selezione degli elementi per più partite.
        * ELIMINARE ALLA CONCLUSIONE DELLE PROVE*/



        for (int j=0; j<10; j++) {
            System.out.println("Nuova prova del metodo");
            equilibrio.putAll(elemento.inizializzaElementiEquilibrio(numero_elementi));

            for (int i = 0; i < equilibrio.size(); i++) {
                System.out.println(equilibrio.get(i).getNome());
            }
            System.out.print("\n");
            equilibrio.clear();




        }




    }
}
