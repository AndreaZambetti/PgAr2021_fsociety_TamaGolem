package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;
import java.util.HashMap;

// step uno capire cosa passargli
public class Match {
    private String vincitore ="";
    private boolean conclusa  = false ;
    private Giocatore player1;
    private Giocatore player2;
    private int lDifficolta;
    private Equilibrio creaEquilibrio ;
    private HashMap<Integer, Elemento> scortaPietre;


    public Match(Giocatore player1, Giocatore player2, int livelloDiffolta) {

        this.player1 = player1;
        this.player2 = player2;
        this.lDifficolta = livelloDiffolta ;

    }


    public String getVincitore() {
        return vincitore;
    }

    public void setVincitore(String vincitore) {
        this.vincitore = vincitore;
    }

    public boolean isConclusa() {
        return conclusa;
    }

    public void setConclusa(boolean conclusa) {
        this.conclusa = conclusa;
    }

    public Giocatore getPlayer1() {
        return player1;
    }

    public void setPlayer1(Giocatore player1) {
        this.player1 = player1;
    }

    public Giocatore getPlayer2() {
        return player2;
    }

    public void setPlayer2(Giocatore player2) {
        this.player2 = player2;
    }

    public int getlDifficolta() {
        return lDifficolta;
    }

    public void setlDifficolta(int lDifficolta) {
        this.lDifficolta = lDifficolta;
    }




    // CREAZIONE LIVELLO DIFFICOLTA
    /*
     * creazione persona nel main vero
     * manca la vita ( bisogna vedere i valori di potenza di ogni difficolta quando li creeremo  )
     */

    public void scegliLivelloDifficolta( int lDifficolta) {
        Elemento.riempi_tutti_elementi();
        switch (lDifficolta) {
            case 1 :
                // 3 pietre per ogni elemento
                /*scortaPietre = 15;*/
                creaEquilibrio = creaEquilibrio.genera_equilibrio(5);
                // inserire le pietre di scorta
                int key;
                for ( int i = 0 ; i < 5; i++ ){
                    for ( int  j =0 ; j< 3 ; j++){
                         key = i *j +j;
                        scortaPietre.put( key, creaEquilibrio.getElementi_equilibrio().get(i) );
                    }
                }
                player1.setnGolem(2);
                player2.setnGolem(2);
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.getArray_golem().get(i).setnPietre(3);
                    player2.getArray_golem().get(i).setnPietre(3);
                }
            break;

            case 2:
                // 4 pietre per ogni elemento
                /*scortaPietre = 28;*/

                 creaEquilibrio = creaEquilibrio.genera_equilibrio(7);
                int key;
                for ( int i = 0 ; i < 7; i++ ){
                    for ( int  j =0 ; j< 4 ; j++){
                        key = i *j +j;
                        scortaPietre.put( key, creaEquilibrio.getElementi_equilibrio().get(i) );
                    }
                }
                player1.setnGolem(3);
                player2.setnGolem(3);
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.getArray_golem().get(i).setnPietre(4);
                    player2.getArray_golem().get(i).setnPietre(4);
                }
            break;

            case 3:
                // 5 pietre per ogni elemento
                /*scortaPietre = 45;*/
                creaEquilibrio = creaEquilibrio.genera_equilibrio(9);
                int key;
                for ( int i = 0 ; i < 9; i++ ){
                    for ( int  j =0 ; j< 5 ; j++){
                        key = i *j +j;
                        scortaPietre.put( key, creaEquilibrio.getElementi_equilibrio().get(i) );
                    }
                }
                player1.setArray_golem();
                player2.setnGolem(3);
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.getArray_golem().get(i).setnPietre(5);
                    player2.getArray_golem().get(i).setnPietre(5);
                }
            break;
        }

    }





    // METODO CHE RITORNA IL VINCITORE DELLA PARTITA ( quando il numero di golem e zero)
    // quando la andremo a dichiarare nel main andra richiamata la classe vincitore e se
    // la classe vincirore e uguale  non e vuota allora pesiste il vincitore e si fermera il ciclo
    public void vediVincitore ( ) {
        if (player1.getArray_golem().size() == 0) {
             vincitore= player1.getNome();
        }
          if (player2.getArray_golem().size() == 0) {
             vincitore = player1.getNome();
        }
    }

    // METODO CHE VA A CAMBIARE IL GOLEM  (i = golem player 1  j = golem player 2)
    public void cambiaGolem(int i, int j ){

        if ( player1.getArray_golem().get(i).isMorto()== true){
            i++;
        }
        if ( player2.getArray_golem().get(j).isMorto()== true){
            j++;
        }
    }

    // SCEGLIERE LE PIETRE stampa pietre e le stampa 

    public void scegliereLePietre ( ){
        for ( int i =0 ; i< scortaPietre.size(); i++){
            System.out.println(scortaPietre.get(i));


        }
    }







}


