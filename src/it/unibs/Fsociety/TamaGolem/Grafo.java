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

    /**
     * metodo che genera lequilibrio
     * @return void
     */
    public void imposta_interazione_elementi(){

        //Set<Integer> lista_casi_da_assegnare = new HashSet<>();
        ArrayList<Integer> casi_da_assegnare = new ArrayList<Integer>();
        int riga_ultimo_inserimento = 0;
        int colonna_ultimo_inserimento = 0;
        int somma_danni_subiti = 0;
        int somma_danni_causati = 0;
        int caso_scelto;
        int selezionato = 0;

        for (int i=0; i < this.dimensione - 1; i++){

            /**CONTROLLA STATO ADIACENZE
             * Controlla quante e quali adiacenze devono essere ancora assegnate.*/

            for (int j=0; j<this.dimensione; j++)
                if (this.matrice_adiacenze[i][j] == -1)
                    casi_da_assegnare.add(j);



            /**BILANCIAMENTO DANNI
             * All'inizio del riempimento dei valori di un elemento verifica la possibile differenza
             * tra i danni subiti e causati, in caso vi sia il bilanciamento viene ristabilito
             * assegnando a una delle adiacenze vacanti il valore della differenza tra i danni in base
             * a quale dei due è in difetto.*/

            for (int j = 0; j < i; j++){
                somma_danni_causati += this.matrice_adiacenze[j][i];
                somma_danni_subiti += this.matrice_adiacenze[i][j];
            }

            //In caso si debba aumentare i danni causati
            if (somma_danni_causati < somma_danni_subiti){

                //Selezione casuale di un indice
                caso_scelto = (int) (Math.random() * casi_da_assegnare.size());
                selezionato = casi_da_assegnare.get(caso_scelto);

                this.matrice_adiacenze[selezionato][i] = somma_danni_subiti - somma_danni_causati;
                this.matrice_adiacenze[i][selezionato] = 0;
                casi_da_assegnare.remove(caso_scelto);

                //Salvataggio dell'ultimo inserimento
                riga_ultimo_inserimento = selezionato;
                colonna_ultimo_inserimento = i;

            } //In caso si debba aumentare i danni subiti
            else if (somma_danni_subiti < somma_danni_causati){

                //Selezione casuale di un indice
                caso_scelto = (int) (Math.random() * casi_da_assegnare.size());
                selezionato = casi_da_assegnare.get(caso_scelto);

                this.matrice_adiacenze[selezionato][i] = 0;
                this.matrice_adiacenze[i][selezionato] = somma_danni_causati - somma_danni_subiti;
                casi_da_assegnare.remove(caso_scelto);

                //Salvataggio dell'ultimo inserimento
                riga_ultimo_inserimento = i;
                colonna_ultimo_inserimento = selezionato;
            }


            /**GENERAZIONE DI DANNI PER COPPIA
             * Riempie i casi da assegnare finché sono accoppiati, ovvero finché è possibile aggiungere
             * danno sia agli elementi che subiscono sia a quelli che infieriscono rispetto all'elemento preso
             * in considerazione*/

            while (casi_da_assegnare.size() > 1){
                int primo_selezionato, secondo_selezionato;

                //Selezione casuale di un indice
                caso_scelto = (int) (Math.random() * casi_da_assegnare.size());
                primo_selezionato = casi_da_assegnare.get(caso_scelto);

                this.matrice_adiacenze[i][primo_selezionato] = (int) (Math.random() * range + minimo_danni);
                this.matrice_adiacenze[primo_selezionato][i] = 0;
                casi_da_assegnare.remove(caso_scelto);

                //Selezione casuale di un indice
                caso_scelto = (int) (Math.random() * casi_da_assegnare.size());
                secondo_selezionato = casi_da_assegnare.get(caso_scelto);

                this.matrice_adiacenze[secondo_selezionato][i] = this.matrice_adiacenze[i][primo_selezionato];
                this.matrice_adiacenze[i][secondo_selezionato] = 0;
                casi_da_assegnare.remove(caso_scelto);

                //Salvataggio dell'ultimo inserimento
                riga_ultimo_inserimento = selezionato;
                colonna_ultimo_inserimento = i;
            }


            /**RIEMPIMENTO ULTIMA ADIACENZA
             * In certe situazioni può capitare che sia rimasto un solo rapporto da assegnare, rendendo quindi
             * impossibile bilanciare i danni con il metodo precedente. Questa funzione ha lo scopo di generare
             * l'ultimo rapporto richiesto, il quale dipende da dove il danno è stato inserito l'ultima volta poiché
             * a tale casella sarà dato il compito di bilanciare quella che ora viene creata*/

            if (casi_da_assegnare.size() == 1){

                //Selezione casuale di un indice, valido per entrambi i casi
                caso_scelto = (int) (Math.random() * casi_da_assegnare.size());
                selezionato = casi_da_assegnare.get(caso_scelto);

                /*Se la riga dell'ultimo inserimento coincide con quella dell'elemento significa che l'ultimo inserimento
                * era un danno subito dall'elemento, quindi il nuovo danno sarà aggiunto alla colonna di indice
                * dell'elemento, in modo che faccia parte di quelli a cui provoca danno*/
                if (riga_ultimo_inserimento == i){

                    this.matrice_adiacenze[selezionato][i] = (int) (Math.random() * range + minimo_danni);
                    this.matrice_adiacenze[i][selezionato] = 0;
                    casi_da_assegnare.remove(caso_scelto);
                    this.matrice_adiacenze[riga_ultimo_inserimento][colonna_ultimo_inserimento] += this.matrice_adiacenze[selezionato][i];

                }
                /*Se la colonna dell'ultimo inserimento coincide con quella dell'elemento significa che l'ultimo inserimento
                 * era un danno causato dall'elemento, quindi il nuovo danno sarà aggiunto alla riga di indice
                 * dell'elemento, in modo che faccia parte di quelli da cui subisce danno*/
                else if (colonna_ultimo_inserimento == i){

                    this.matrice_adiacenze[i][selezionato] = (int) (Math.random() * range + minimo_danni);
                    this.matrice_adiacenze[selezionato][i] = 0;
                    casi_da_assegnare.remove(caso_scelto);
                    this.matrice_adiacenze[riga_ultimo_inserimento][colonna_ultimo_inserimento] += this.matrice_adiacenze[i][selezionato];

                }
            }

            //Resettare a fine ciclo
            casi_da_assegnare.clear();
            somma_danni_subiti = 0;
            somma_danni_causati = 0;
        }
    }
}
