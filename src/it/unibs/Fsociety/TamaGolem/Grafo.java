package it.unibs.Fsociety.TamaGolem;

import java.util.*;

public class Grafo {

    private static int range = 11;
    private static int minimo_danni = 10;

    private int dimensione;
    private int[][] matrice_adiacenze;

    public Grafo(int dimensione) {
        this.dimensione = dimensione;
        this.matrice_adiacenze = new int[dimensione][dimensione];
        //Impostazione di base della matrice
        for (int i=0; i<dimensione; i++)
            for (int j=0; j< dimensione; j++)
                if (i!=j)
                    matrice_adiacenze [i][j] = 1;
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
        int somma_danni = 0;

        for (int i=0; i<this.dimensione; i++){

            /**CONTROLLA STATO ADIACENZE
             * Controlla la condizione degli elementi rispetto a uno preso in analisi,
             * rappresentato dall'indice i, attraverso i valori presenti nelle colonne
             * della riga di quell'elemento nella matrice_adiacenze:
             * 1) conta quanti infieriscono danno all'elemento
             * 2) conta quanti infieriscono danno dall'elemento
             * 3) conta quanti devono essere ancora assegnati*/

            for (int j=0; j<this.dimensione; j++) {
                switch (this.matrice_adiacenze[i][j]){
                    case 0:
                        //L'elemento stesso non deve essere considerato tra quelli che infieriscono
                        if (i!=j)
                            quali_subiscono.add(j);
                        break;
                    case 1:
                        casi_da_assegnare.add(j);
                        break;
                    default:
                        quali_infieriscono.add(j);
                        break;
                }
            }

            /**ASSEGNA GRUPPI APPARTENENZA INDICI
             * Questa parte di programma da un'assegnazione alle adiacenze che ancora non la possiedono,
             * tali adiacenze sono state precedentemente inserite nel Set casi_da_assegnare,
             * di conseguenza sono facilmente individuabili*/

            /*Viene generato un quoziente casuale per decidere randomicamente
             * quanti elementi andranno a formare i set, il quoziente può valere da 2 a 5*/
            int quoziente_casuale = (int) (Math.random() * 4 + 2);

            /*In caso ci siano adiacenze da assegnare*/
            if (!casi_da_assegnare.isEmpty()){
                int assegnare = casi_da_assegnare.size();
                for (int j = 0; j < assegnare; j++){

                    if (j % quoziente_casuale == 0){
                        int selezionato;
                        do {
                            /*Selezione casuale di un indice*/
                            selezionato = (int) (Math.random() * this.dimensione);
                        } while(!casi_da_assegnare.contains(selezionato));
                        /*La condizione che l'indice sia presente nell'elenco dovrebbe essere
                        * sufficiente alla corretta assegnazione, tenere comunque conto del fatto
                        * che possa essere causa di problemi in fase di test*/

                        /*L'elemento viene aggiunto a quelli che infieriscono e viene rimosso
                        * da quelli da assegnare*/
                        quali_infieriscono.add(selezionato);
                        casi_da_assegnare.remove(selezionato);
                    }
                    else{
                        int selezionato;
                        do {
                            /*Selezione casuale di un indice*/
                            selezionato = (int) (Math.random() * this.dimensione);
                        } while(!casi_da_assegnare.contains(selezionato));
                        /*La condizione che l'indice sia presente nell'elenco dovrebbe essere
                         * sufficiente alla corretta assegnazione, tenere comunque conto del fatto
                         * che possa essere causa di problemi in fase di test*/

                        /*L'elemento viene aggiunto a quelli che infieriscono e viene rimosso
                         * da quelli da assegnare*/
                        quali_subiscono.add(selezionato);
                        casi_da_assegnare.remove(selezionato);
                    }
                }
            }

            /***/

            ArrayList<Integer> infieriscono = new ArrayList<Integer>();
            infieriscono.addAll(quali_infieriscono);

            for (int j=0; j<infieriscono.size(); j++){
                int indice = infieriscono.get(j);
                this.matrice_adiacenze[i][indice] = (int)(Math.random() * range + minimo_danni);
                somma_danni += this.matrice_adiacenze[i][indice];
                this.matrice_adiacenze[indice][i] = 0;
            }

            ArrayList<Integer> subiscono = new ArrayList<Integer>();
            subiscono.addAll(quali_subiscono);

            for (int j=0; j < (subiscono.size()-1); j++){
                int indice = subiscono.get(j);
                this.matrice_adiacenze[indice][i] = (int)(Math.random() * range + minimo_danni);
                somma_danni -= this.matrice_adiacenze[indice][i];
                this.matrice_adiacenze[i][indice] = 0;
            }

            /*Questa parte di programma ha lo scopo di rendere nulla la somma dei danni
            * subiti e causati nel caso non sia già*/
            if (somma_danni != 0){
                /*Se la somma fosse maggiore di 0 significherebbe che l'elemento subisce più danni
                * di quanti ne causa, di conseguenza i danni mancanti vanno aggiuti all'elenco
                * dei danni che causa*/
                if (somma_danni > 0){
                    int selezionato;
                    do {
                        /*Selezione casuale di un indice*/
                        selezionato = (int) (Math.random() * this.dimensione);
                    } while(!quali_subiscono.contains(selezionato));

                    this.matrice_adiacenze[selezionato][i] += somma_danni;
                }
                /*Se la somma fosse minore di 0 significherebbe che l'elemento causa più danni
                 * di quanti ne subisce, di conseguenza i danni mancanti vanno aggiuti all'elenco
                 * dei danni che subisce*/
                else {
                    int selezionato;
                    do {
                        /*Selezione casuale di un indice*/
                        selezionato = (int) (Math.random() * this.dimensione);
                    } while(!quali_infieriscono.contains(selezionato));

                    this.matrice_adiacenze[i][selezionato] -= somma_danni;
                }

            }

            /*Svuotare i Set a fine ciclo*/
            quali_infieriscono.clear();
            quali_subiscono.clear();
            infieriscono.clear();
            subiscono.clear();

            /*ArrayList<Integer> infieriscono = new ArrayList<Integer>();
            infieriscono.addAll(quali_infieriscono);
            ArrayList<Integer> infieriscono = new ArrayList<Integer>();
            infieriscono.addAll(quali_subiscono);

            System.out.print("Subiscono: ");
            for (int j=0; j<infieriscono.size(); j++)
                System.out.print(infieriscono.get(j) + "; ");
            System.out.println("\n");

            System.out.print("Infieriscono: ");
            for (int j=0; j<infieriscono.size(); j++)
                System.out.print(infieriscono.get(j) + "; ");
            System.out.println("\n");

            quali_infieriscono.clear();
            quali_subiscono.clear();
            quali_infieriscono.clear();
            quali_subiscono.clear();*/
        }
    }
}
