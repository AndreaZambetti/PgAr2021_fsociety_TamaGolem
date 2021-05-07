package it.unibs.Fsociety.TamaGolem;

// step uno capire cosa passargli
public class Match {
    private String vincitore ="";
    private boolean conclusa  = false ;
    private Giocatore player1;
    private Giocatore player2;
    private int lDifficolta;
    private int scortaPietre ;


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
        conclusa = conclusa;
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

    public int getScortaPietre() {
        return scortaPietre;
    }

    public void setScortaPietre(int scortaPietre) {
        this.scortaPietre = scortaPietre;
    }


    // CREAZIONE LIVELLO DIFFICOLTA
    /*
     * creazione persona nel main vero
     * manca la vita ( bisogna vedere i valori di potenza di ogni difficolta quando li creeremo  )
     */

    public void scegliLivelloDifficolta( int lDifficolta) {

        switch (lDifficolta) {
            case 1 :
                scortaPietre = 12;

                Elemento.creaNuovoEquilibrio(5);

                player1.setnGolem(2);
                player2.setnGolem(2);
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.getArray_golem().get(i).setnPietre(3);
                    player2.getArray_golem().get(i).setnPietre(3);
                }
            break;

            case 2:
                scortaPietre = 24;
                Elemento.creaNuovoEquilibrio(7);
                player1.setnGolem(3);
                player2.setnGolem(3);
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.getArray_golem().get(i).setnPietre(4);
                    player2.getArray_golem().get(i).setnPietre(4);
                }
            break;

            case 3:
                scortaPietre = 135;
                Elemento.creaNuovoEquilibrio(9);
                player1.setnGolem(3);
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

    // METODO CHE VA A CAMBIARE IL TURNO ( cambia turno)
    public int cambiaTurno(int i  ){

        if ( player1.getArray_golem().get(i).getVita()==0){
            i++;
        }
        if ( player2.getArray_golem().get(i).getVita()== 0){
            i++;
        }

        return i;
    }
}


