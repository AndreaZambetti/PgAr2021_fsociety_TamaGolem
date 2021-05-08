package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {

    private static int range = 10;
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

        int quanti_subiscono, quanti_infieriscono;

        for (int i=0; i<this.dimensione; i++){
            for (int j=0; j<this.dimensione; j++){
                /*Grazie all'impostazione del costruttore il valore 1 è considerato indicatore
                  di effetto non ancora impostato*/
                if (matrice_adiacenze[i][j] == 1){

                    //selezione di quanti elementi subiranno danno dall'elemento in questione
                    quanti_subiscono = (int) (Math.random() * (dimensione - 2) + 1);

                }
            }
        }
    }
}
