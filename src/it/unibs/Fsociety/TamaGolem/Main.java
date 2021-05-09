package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //chiamare sempre a inizio programma per inizializzare gli elementi
        Elemento.riempi_tutti_elementi();

        int numero_elementi = 9;

        Equilibrio equilibrio = new Equilibrio();
        //equilibrio = equilibrio.genera_equilibrio(numero_elementi);

        /*Test funzione di creazione equilibrio
        Equilibrio equilibrio = new Equilibrio();

        for (int i=0; i<10; i++){
            //Chiamata funzione per la generazione di un nuovo equilibrio
            equilibrio = equilibrio.genera_equilibrio(numero_elementi);
            System.out.println("Elementi nuova partita:");
            for (int j = 0; j<equilibrio.getElementi_equilibrio().size(); j++){
                System.out.println(equilibrio.getElementi_equilibrio().get(j).getNome_elemento());
            }
        } //*/

        /*TEST INTERA GENERAZIONE EQUILIBRIO*/
        for (int i=0; i<10; i++){
            equilibrio = equilibrio.genera_equilibrio(numero_elementi);

            for (int j=0; j<equilibrio.getElementi_equilibrio().size(); j++){
                System.out.println("Indice " + equilibrio.getElementi_equilibrio().get(j).getNome_elemento() + ": " + j);
            }

            for (int j=0; j<equilibrio.getElementi_equilibrio().size(); j++){
                for (int k=0; k<equilibrio.getElementi_equilibrio().size(); k++){
                    //System.out.print(equilibrio.getInterazione_elementi().get_adiacenza(j, k) + " |\t");
                    System.out.print(String.format("|%3d", equilibrio.getInterazione_elementi().get_adiacenza(j, k)));
                }
                System.out.println();
            }
        }
    }
}
