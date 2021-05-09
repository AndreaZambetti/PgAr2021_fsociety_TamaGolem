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

        Set<Integer> quali_subiscono = new HashSet<>();
        Set<Integer> quali_infieriscono = new HashSet<>();
        Set<Integer> casi_da_assegnare = new HashSet<>();
        int somma, effetto;

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
                            quali_infieriscono.add(j);
                        break;
                    case 1:
                        casi_da_assegnare.add(j);
                        break;
                    default:
                        quali_subiscono.add(j);
                        break;
                }
            }

            /***/
            /*Viene generato un quoziente casuale per decidere randomicamente
             * quanti elementi andranno a formare i set, il quoziente può valere 2, 3 o 4*/
            int quoziente_casuale = (int) (Math.random() * 3 + 2);
            System.out.println("Quoziente casuale: " + quoziente_casuale);

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

                        /*L'elemento viene aggiunto a quelli che subiscono e viene rimosso
                        * da quelli da assegnare*/
                        quali_subiscono.add(selezionato);
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
                        quali_infieriscono.add(selezionato);
                        casi_da_assegnare.remove(selezionato);
                    }
                }
            }

            /*Svuotare i Set a fine ciclo* /
            quali_subiscono.clear();
            quali_infieriscono.clear();*/

            ArrayList<Integer> subiscono = new ArrayList<Integer>();
            subiscono.addAll(quali_subiscono);
            ArrayList<Integer> infieriscono = new ArrayList<Integer>();
            infieriscono.addAll(quali_infieriscono);

            System.out.print("Subiscono: ");
            for (int j=0; j<subiscono.size(); j++)
                System.out.print(subiscono.get(j) + "; ");
            System.out.println("\n");

            System.out.print("Infieriscono: ");
            for (int j=0; j<infieriscono.size(); j++)
                System.out.print(infieriscono.get(j) + "; ");
            System.out.println("\n");

            quali_subiscono.clear();
            subiscono.clear();
            quali_infieriscono.clear();
            infieriscono.clear();
        }
    }
}
