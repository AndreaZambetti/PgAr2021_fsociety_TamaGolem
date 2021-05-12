package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Grafo {

    private static int range = 5;
    private static int minimo_danni = 1;

    private int dimensione;
    private int[][] matrice_adiacenze;

    public Grafo(int dimensione) {
        this.dimensione = dimensione;
        this.matrice_adiacenze = new int[dimensione][dimensione];
        //Impostazione di base della matrice
        for (int i=0; i<dimensione; i++)
            for (int j=0; j< dimensione; j++)
                if (i!=j)
                    matrice_adiacenze [i][j] = -1;
                else
                    matrice_adiacenze [i][j] = 0;
    }

    public int[][] getMatrice_adiacenze() {
        return matrice_adiacenze;
    }

    public int get_adiacenza(int riga, int colonna) {
        return matrice_adiacenze[riga][colonna];
    }

    public void setMatrice_adiacenze(int[][] matrice_adiacenze) {
        this.matrice_adiacenze = matrice_adiacenze;
    }

    public void imposta_interazione_elementi(){

        //Set<Integer> quali_infieriscono = new HashSet<>();
        //Set<Integer> quali_subiscono = new HashSet<>();
        Set<Integer> casi_da_assegnare = new HashSet<>();
        int riga_ultimo_inserimento = 0;
        int colonna_ultimo_inserimento = 0;
        int somma_danni_subiti = 0;
        int somma_danni_causati = 0;
        int selezionato = 0;

        for (int i=0; i < this.dimensione; i++){

            /**CONTROLLA STATO ADIACENZE
             * Controlla la condizione degli elementi rispetto a uno preso in analisi,
             * rappresentato dall'indice i, attraverso i valori presenti nelle colonne
             * della riga di quell'elemento nella matrice_adiacenze:
             * 1) conta quanti infieriscono danno all'elemento
             * 2) conta quanti subiscono danno dall'elemento
             * 3) conta quanti devono essere ancora assegnati*/

            for (int j=0; j<this.dimensione; j++)
                if (this.matrice_adiacenze[i][j] == -1)
                    casi_da_assegnare.add(j);


            /**All'inizio del riempimento dei valori di un elemento verifica la possibile differenza
             * tra i danni subiti e causati, in caso vi sia l'equilibrio viene ristabilito
             * assegnando a una delle adiacenze vacanti il valore della differenza tra i danni*/

            for (int j = 0; j < i; j++){
                somma_danni_causati += this.matrice_adiacenze[j][i];
                somma_danni_subiti += this.matrice_adiacenze[i][j];
            }

            //In caso si debba aumentare i danni causati
            if (somma_danni_causati < somma_danni_subiti){
                do {
                    /*Selezione casuale di un indice*/
                    selezionato = (int) (Math.random() * this.dimensione);
                } while(!casi_da_assegnare.contains(selezionato));

                this.matrice_adiacenze[selezionato][i] = somma_danni_subiti - somma_danni_causati;
                this.matrice_adiacenze[i][selezionato] = 0;
                casi_da_assegnare.remove(selezionato);
                riga_ultimo_inserimento = selezionato;
                colonna_ultimo_inserimento = i;

            } //In caso si debba aumentare i danni subiti
            else if (somma_danni_subiti < somma_danni_causati){
                do {
                    /*Selezione casuale di un indice*/
                    selezionato = (int) (Math.random() * this.dimensione);
                } while(!casi_da_assegnare.contains(selezionato));

                this.matrice_adiacenze[selezionato][i] = 0;
                this.matrice_adiacenze[i][selezionato] = somma_danni_causati - somma_danni_subiti;
                casi_da_assegnare.remove(selezionato);
                riga_ultimo_inserimento = i;
                colonna_ultimo_inserimento = selezionato;
            }

            /**

            if (!quali_infieriscono.isEmpty()){
                infieriscono.addAll(quali_infieriscono);
                for (int j = 0; j < quali_infieriscono.size() && !casi_da_assegnare.isEmpty(); j++){
                    int selezionato;
                    do {
                        /*Selezione casuale di un indice* /
                        selezionato = (int) (Math.random() * this.dimensione);
                    } while(!casi_da_assegnare.contains(selezionato));

                    this.matrice_adiacenze[selezionato][i] = this.matrice_adiacenze[i][infieriscono.get(j)];
                    this.matrice_adiacenze[i][selezionato] = 0;
                    casi_da_assegnare.remove(selezionato);
                }
            }*/

            /**

            if (!quali_subiscono.isEmpty()){
                subiscono.addAll(quali_subiscono);
                for (int j = 0; j < quali_subiscono.size() && !casi_da_assegnare.isEmpty(); j++){
                    int selezionato;
                    do {
                        /*Selezione casuale di un indice* /
                        selezionato = (int) (Math.random() * this.dimensione);
                    } while(!casi_da_assegnare.contains(selezionato));

                    this.matrice_adiacenze[i][selezionato] = this.matrice_adiacenze[subiscono.get(j)][i];
                    this.matrice_adiacenze[selezionato][i] = 0;
                    casi_da_assegnare.remove(selezionato);
                }
            }*/


            /**Riempie i casi da assegnare finché sono più di uno*/

            while (casi_da_assegnare.size() > 1){
                int primo_selezionato, secondo_selezionato;
                do {
                    /*Selezione casuale di un indice*/
                    primo_selezionato = (int) (Math.random() * this.dimensione);
                } while (!casi_da_assegnare.contains(primo_selezionato));

                this.matrice_adiacenze[i][primo_selezionato] = (int) (Math.random() * range + minimo_danni);
                this.matrice_adiacenze[primo_selezionato][i] = 0;
                casi_da_assegnare.remove(primo_selezionato);

                do {
                    /*Selezione casuale di un indice*/
                    secondo_selezionato = (int) (Math.random() * this.dimensione);
                } while (!casi_da_assegnare.contains(secondo_selezionato));

                this.matrice_adiacenze[secondo_selezionato][i] = this.matrice_adiacenze[i][primo_selezionato];
                this.matrice_adiacenze[i][secondo_selezionato] = 0;
                casi_da_assegnare.remove(secondo_selezionato);
                riga_ultimo_inserimento = selezionato;
                colonna_ultimo_inserimento = i;
            }


            if (casi_da_assegnare.size() == 1){
                do {
                    //Selezione casuale di un indice
                    selezionato = (int) (Math.random() * this.dimensione);
                } while(!casi_da_assegnare.contains(selezionato));

                this.matrice_adiacenze[i][selezionato] = (int) (Math.random() * range + minimo_danni);
                this.matrice_adiacenze[selezionato][i] = 0;
                casi_da_assegnare.remove(selezionato);

                //ERRORE NELL'INSERIMENTO NELL'ULTIMA CASELLA USATA
                this.matrice_adiacenze[riga_ultimo_inserimento][colonna_ultimo_inserimento] += this.matrice_adiacenze[i][selezionato];
            }

            /*Svuotare i Set a fine ciclo*/
            //quali_infieriscono.clear();
            //quali_subiscono.clear();
            somma_danni_subiti = 0;
            somma_danni_causati = 0;
        }
    }
}
