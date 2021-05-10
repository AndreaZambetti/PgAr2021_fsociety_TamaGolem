package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Chiamare sempre a inizio programma per inizializzare gli elementi
        Elemento.riempi_tutti_elementi();

        int numero_elementi = 9;

        Equilibrio equilibrio = new Equilibrio();

        /*TEST INTERA GENERAZIONE EQUILIBRIO*/
        for (int i=0; i<10; i++){
            equilibrio = equilibrio.genera_equilibrio(numero_elementi);

            System.out.println("Nuovo test");

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
