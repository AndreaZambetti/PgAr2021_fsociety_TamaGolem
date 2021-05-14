package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Equilibrio {

    private HashMap<Integer, Elemento> elementi_equilibrio;
    private Grafo interazione_elementi;


    public Equilibrio(HashMap<Integer, Elemento> elementi_equilibrio) {
        this.elementi_equilibrio = elementi_equilibrio;
    }

    public Equilibrio() {
    }

    public String getNomeElementoEquilibrio(int index){
        return this.getElementi_equilibrio().get(index).getNome_elemento();
    }

    public Grafo getInterazione_elementi() {
        return interazione_elementi;
    }

    public HashMap<Integer, Elemento> getElementi_equilibrio() {
        return elementi_equilibrio;
    }

    public void setInterazione_elementi(Grafo interazione_elementi) {
        this.interazione_elementi = interazione_elementi;
    }

    /**
     * metodo che permette di generare lequilibrio
     * @param numero_elementi
     * @return Equilibrio
     */
    public static Equilibrio genera_equilibrio(int numero_elementi) {

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

    /**
     * metodo che serve per stampare l`equilibrio
     * @return void
     */
    public void stampaEquilibrio() {
        int somma_riga = 0;
        int somma_colonna = 0;

        System.out.println("EQUILIBRIO:");
        System.out.print("\t\t ");

        //Stampa nomi elementi
        for (int j = 0; j < this.getElementi_equilibrio().size(); j++) {
            switch (this.getElementi_equilibrio().get(j).getNome_elemento().length()) {
                case 4:
                    System.out.print(String.format("  %s   ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 5:
                    System.out.print(String.format("  %s  ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 7:
                    System.out.print(String.format(" %s ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 9:
                    System.out.print(String.format("%s", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
            }
        }

        System.out.println(" totale  \n");

        for (int j = 0; j < this.getElementi_equilibrio().size(); j++) {

            switch (this.getElementi_equilibrio().get(j).getNome_elemento().length()) {
                case 4:
                    System.out.print(String.format("  %s   ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 5:
                    System.out.print(String.format("  %s  ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 7:
                    System.out.print(String.format(" %s ", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
                case 9:
                    System.out.print(String.format("%s", this.getElementi_equilibrio().get(j).getNome_elemento()));
                    break;
            }

            for (int k = 0; k < this.getElementi_equilibrio().size(); k++) {
                System.out.print(String.format("%5d    ", this.getInterazione_elementi().get_adiacenza(j, k)));
                somma_riga += this.getInterazione_elementi().get_adiacenza(j, k);
            }
            System.out.println(String.format(" -> %d\n", somma_riga));

            somma_riga = 0;
        }

        System.out.print("\t\t\t |");
        for (int j = 0; j < this.getElementi_equilibrio().size() - 1; j++) {
            System.out.print("        |");
        }

        System.out.print("\n totale  ");

        for (int j = 0; j < this.getElementi_equilibrio().size(); j++) {
            for (int k = 0; k < this.getElementi_equilibrio().size(); k++) {
                somma_colonna += this.getInterazione_elementi().get_adiacenza(k, j);
            }
            System.out.print(String.format("%5d    ", somma_colonna));
            somma_colonna = 0;
        }

        System.out.println("\n");
    }
}