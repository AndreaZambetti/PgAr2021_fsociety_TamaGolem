package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Grafo {

    private static int range = 6;
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

        Set<Integer> quali_infieriscono = new HashSet<>();
        Set<Integer> quali_subiscono = new HashSet<>();
        Set<Integer> casi_da_assegnare = new HashSet<>();
        ArrayList<Integer> infieriscono = new ArrayList<Integer>();
        ArrayList<Integer> subiscono = new ArrayList<Integer>();
        //int quoziente_casuale;
        //int somma_danni_subiti = 0;
        //int somma_danni_causati = 0;

        for (int i=0; i<this.dimensione; i++){

            /**CONTROLLA STATO ADIACENZE
             * Controlla la condizione degli elementi rispetto a uno preso in analisi,
             * rappresentato dall'indice i, attraverso i valori presenti nelle colonne
             * della riga di quell'elemento nella matrice_adiacenze:
             * 1) conta quanti infieriscono danno all'elemento
             * 2) conta quanti subiscono danno dall'elemento
             * 3) conta quanti devono essere ancora assegnati*/

            for (int j=0; j<this.dimensione; j++) {
                switch (this.matrice_adiacenze[i][j]){
                    case 0:
                        //L'elemento stesso non deve essere considerato tra quelli che infieriscono
                        if (i!=j)
                            quali_subiscono.add(j);
                        break;
                    case -1:
                        casi_da_assegnare.add(j);
                        break;
                    default:
                        quali_infieriscono.add(j);
                        break;
                }
            }

            if (!quali_infieriscono.isEmpty()){
                infieriscono.addAll(quali_infieriscono);
                for (int j = 0; j < quali_infieriscono.size() && !casi_da_assegnare.isEmpty(); j++){
                    int selezionato;
                    do {
                            /*Selezione casuale di un indice*/
                            selezionato = (int) (Math.random() * this.dimensione);
                        } while(!casi_da_assegnare.contains(selezionato));

                    this.matrice_adiacenze[selezionato][i] = this.matrice_adiacenze[i][infieriscono.get(j)];
                    this.matrice_adiacenze[i][selezionato] = 0;
                    casi_da_assegnare.remove(selezionato);
                }
            }

            if (!quali_subiscono.isEmpty()){
                subiscono.addAll(quali_subiscono);
                for (int j = 0; j < quali_subiscono.size() && !casi_da_assegnare.isEmpty(); j++){
                    int selezionato;
                    do {
                        /*Selezione casuale di un indice*/
                        selezionato = (int) (Math.random() * this.dimensione);
                    } while(!casi_da_assegnare.contains(selezionato));

                    this.matrice_adiacenze[i][selezionato] = this.matrice_adiacenze[subiscono.get(j)][i];
                    this.matrice_adiacenze[selezionato][i] = 0;
                    casi_da_assegnare.remove(selezionato);
                }
            }

            int cicli = casi_da_assegnare.size() / 2;
            for (int j=0; j<cicli; j++){
                int primo_selezionato, secondo_selezionato;
                do {
                    /*Selezione casuale di un indice*/
                    primo_selezionato = (int) (Math.random() * this.dimensione);
                } while(!casi_da_assegnare.contains(primo_selezionato));

                this.matrice_adiacenze[i][primo_selezionato] = (int)(Math.random() * range + minimo_danni);;
                this.matrice_adiacenze[primo_selezionato][i] = 0;
                casi_da_assegnare.remove(primo_selezionato);

                do {
                    /*Selezione casuale di un indice*/
                    secondo_selezionato = (int) (Math.random() * this.dimensione);
                } while(!casi_da_assegnare.contains(secondo_selezionato));

                this.matrice_adiacenze[secondo_selezionato][i] = this.matrice_adiacenze[i][primo_selezionato];
                this.matrice_adiacenze[i][secondo_selezionato] = 0;
                casi_da_assegnare.remove(secondo_selezionato);
            }



            /**ASSEGNA GRUPPI APPARTENENZA INDICI
             * Questa parte di programma da un'assegnazione alle adiacenze che ancora non la possiedono,
             * tali adiacenze sono state precedentemente inserite nel Set casi_da_assegnare,
             * di conseguenza sono facilmente individuabili*/

            /*Viene generato un quoziente casuale per decidere randomicamente
             * quanti elementi andranno a formare i set, il quoziente può valere da 2 a 5*/
            /*quoziente_casuale = (int) (Math.random() * 4 + 2);

            /*In caso ci siano adiacenze da assegnare* /
            if (!casi_da_assegnare.isEmpty()){
                int assegnare = casi_da_assegnare.size();
                for (int j = 0; j < assegnare; j++){

                    if (j % quoziente_casuale == 0){
                        int selezionato;
                        do {
                            /*Selezione casuale di un indice* /
                            selezionato = (int) (Math.random() * this.dimensione);
                        } while(!casi_da_assegnare.contains(selezionato));
                        /*La condizione che l'indice sia presente nell'elenco dovrebbe essere
                        * sufficiente alla corretta assegnazione, tenere comunque conto del fatto
                        * che possa essere causa di problemi in fase di test*/

                        /*L'elemento viene aggiunto a quelli che infieriscono e viene rimosso
                        * da quelli da assegnare* /
                        quali_infieriscono.add(selezionato);
                        casi_da_assegnare.remove(selezionato);
                    }
                    else{
                        int selezionato;
                        do {
                            /*Selezione casuale di un indice* /
                            selezionato = (int) (Math.random() * this.dimensione);
                        } while(!casi_da_assegnare.contains(selezionato));
                        /*La condizione che l'indice sia presente nell'elenco dovrebbe essere
                         * sufficiente alla corretta assegnazione, tenere comunque conto del fatto
                         * che possa essere causa di problemi in fase di test*/

                        /*L'elemento viene aggiunto a quelli che infieriscono e viene rimosso
                         * da quelli da assegnare* /
                        quali_subiscono.add(selezionato);
                        casi_da_assegnare.remove(selezionato);
                    }
                }
            }



            ArrayList<Integer> infieriscono = new ArrayList<Integer>();
            infieriscono.addAll(quali_infieriscono);

            for (int j=0; j<infieriscono.size(); j++){
                int indice = infieriscono.get(j);
                this.matrice_adiacenze[i][indice] = (int)(Math.random() * range + minimo_danni);
                somma_danni_subiti += this.matrice_adiacenze[i][indice];
                this.matrice_adiacenze[indice][i] = 0;
            }

            ArrayList<Integer> subiscono = new ArrayList<Integer>();
            subiscono.addAll(quali_subiscono);

            for (int j=0; j < subiscono.size() - 1; j++){
                int indice = subiscono.get(j);
                this.matrice_adiacenze[indice][i] = (int)(Math.random() * range + minimo_danni);
                somma_danni_causati += this.matrice_adiacenze[indice][i];
                this.matrice_adiacenze[i][indice] = 0;
            }*/

            /**BILANCIAMENTO DANNI
             * Questa parte di programma ha lo scopo di rendere nulla la differenza dei danni
             * subiti e causati da un elemento nel caso i due valori non sia già uguali*/

            /**VECCHIA VERSIONE BILANCIAMENTO* /
            for (int j = 0; j < this.dimensione; j++) {
                /*Calcola l'ammontare di danni subiti da un elemento sommando i valori presenti
                 * nelle caselle della riga che rappresenta l'elemento* /
                somma_danni_subiti += this.matrice_adiacenze[i][j];

                /*Calcola l'ammontare di danni causati da un elemento sommando i valori presenti
                 * nelle caselle della colonna che rappresenta l'elemento* /
                somma_danni_causati += this.matrice_adiacenze[j][i];
            }

            /*In caso i danni causati siano meno di quelli subiti* /
            if (somma_danni_causati < somma_danni_subiti){
                int selezionato;
                do {
                    /*Selezione casuale di un indice* /
                    selezionato = (int) (Math.random() * this.dimensione);
                } while((!quali_infieriscono.contains(selezionato)) && (selezionato > i));

                /*Aggiunge la differenza dai danni alla casella selezionata* /
                this.matrice_adiacenze[i][selezionato] += somma_danni_subiti - somma_danni_causati;
            }
            /*In caso i danni subiti siano meno di quelli causati* /
            else if (somma_danni_subiti < somma_danni_causati){
                int selezionato;
                do {
                    /*Selezione casuale di un indice* /
                    selezionato = (int) (Math.random() * this.dimensione);
                } while((!quali_subiscono.contains(selezionato)) && (selezionato > i));

                /*Aggiunge la differenza dai danni alla casella selezionata* /
                this.matrice_adiacenze[selezionato][i] += somma_danni_causati - somma_danni_subiti;
            }*/



            /*Svuotare i Set a fine ciclo*/
            quali_infieriscono.clear();
            quali_subiscono.clear();
            infieriscono.clear();
            subiscono.clear();
            //somma_danni_subiti = 0;
            //somma_danni_causati = 0;
        }
    }
}
