package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //*

        //Chiamare sempre a inizio programma per inizializzare gli elementi
        Elemento.riempi_tutti_elementi();

        int numero_elementi = 7;

        Equilibrio equilibrio = new Equilibrio();

        int somma_riga = 0;
        int somma_colonna = 0;

        //Esegue 20 test di generazione dell'equilibrio
        //for (int i = 0; i < 20; i++) {
            //equilibrio = equilibrio.genera_equilibrio(numero_elementi);
            equilibrio = Equilibrio.genera_equilibrio(numero_elementi);

            //System.out.println("Nuovo test");

            System.out.print("\t\t ");

            //Stampa nomi elementi
            for (int j=0; j<equilibrio.getElementi_equilibrio().size(); j++){
                switch (equilibrio.getElementi_equilibrio().get(j).getNome_elemento().length()){
                    case 4:
                        System.out.print(String.format("  %s   ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 5:
                        System.out.print(String.format("  %s  ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 7:
                        System.out.print(String.format(" %s ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 9:
                        System.out.print(String.format("%s", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                }
            }

            System.out.println(" totale  \n");

            for (int j = 0; j < equilibrio.getElementi_equilibrio().size(); j++) {

                switch (equilibrio.getElementi_equilibrio().get(j).getNome_elemento().length()){
                    case 4:
                        System.out.print(String.format("  %s   ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 5:
                        System.out.print(String.format("  %s  ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 7:
                        System.out.print(String.format(" %s ", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                    case 9:
                        System.out.print(String.format("%s", equilibrio.getElementi_equilibrio().get(j).getNome_elemento()));
                        break;
                }

                for (int k = 0; k < equilibrio.getElementi_equilibrio().size(); k++) {
                    System.out.print(String.format("%5d    ", equilibrio.getInterazione_elementi().get_adiacenza(j, k)));
                    somma_riga += equilibrio.getInterazione_elementi().get_adiacenza(j, k);
                }
                System.out.println(String.format(" -> %d\n", somma_riga));

                somma_riga = 0;
            }

            System.out.print("\t\t\t |");
            for (int j = 0; j < equilibrio.getElementi_equilibrio().size() - 1; j++) {
                System.out.print("        |");
            }

            System.out.print("\n totale  ");

            for (int j = 0; j < equilibrio.getElementi_equilibrio().size(); j++) {
                for (int k = 0; k < equilibrio.getElementi_equilibrio().size(); k++) {
                    somma_colonna += equilibrio.getInterazione_elementi().get_adiacenza(k, j);
                }
                System.out.print(String.format("%5d    ", somma_colonna));
                somma_colonna = 0;
            }

            System.out.println("\n");
        //}//*/
    }
}
