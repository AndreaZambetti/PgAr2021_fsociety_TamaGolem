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

    public void setMatrice_adiacenze(int[][] matrice_adiacenze) {
        this.matrice_adiacenze = matrice_adiacenze;
    }

    public void imposta_interazione_elementi(){

        int quanti_subiscono, quanti_infieriscono, somma, effetto, casi_da_assegnare = 0;
        Set<Integer> elenco_elementi_assegnati = new HashSet<>();

        for (int i=0; i<this.dimensione; i++){

            //Controlla quanti elementi in una riga devono essere ancora assegnati
            for (int j=0; j<dimensione; j++)
                if (this.matrice_adiacenze[i][j] == 1)
                    casi_da_assegnare++;

            //Stabilisce quanti elementi provocano o ricevono effetti all'elemento in analisi
            quanti_subiscono = (int) (Math.random() * (casi_da_assegnare - 2) + 1);
            quanti_infieriscono = casi_da_assegnare - 1 - quanti_subiscono;

            //Stabilisce quali elementi subiscono danni dall'elemento in analisi
            for (int j=0; j<quanti_subiscono; j++)
                /*continua a selezionare casualmente finché non ottiene gli indici richiesti,
                * inoltre nessuno degli indici deve essere uguale a quello dell'elemento in analisi*/
                while (elenco_elementi_assegnati.size() < quanti_subiscono && elenco_elementi_assegnati.contains(i)) {
                    elenco_elementi_assegnati.add((int) (Math.random() * dimensione));
                }
        }
    }
}
