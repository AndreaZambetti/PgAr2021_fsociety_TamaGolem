package it.unibs.Fsociety.TamaGolem;

// step uno capire cosa passargli
public class Match {
    private String vincitore;
    private boolean conclusa ;
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

    // CREAZIONE LIVELLO DIFFICOLTA
    /*
     * mancano gli elemnti e le pietre di scorta per ogni incontro
     * creazione persona nel main vero
     * manca la vita ( bisogna vedere i valori di potenza di ogni difficolta quando li creeremo  )
     */

    public void scegliLivelloDifficolta( ) {
            int num ;

        if (lDifficolta == 1) {
            num = 5;
            Elemento.creaNuovoEquilibrio( num  );
            /*player1.setnGolem().npietre = 3;
            player2.setnGolem().npietre = 3;*/
            player1.setnGolem(2);
            player2.setnGolem(2);

        } if ( lDifficolta == 2 )  {
            num = 7;
            Elemento.creaNuovoEquilibrio( num );
            /*player1.nGolem.npietre = 4;
            player2.nGolem.npietre = 4;*/
            player1.setnGolem(3);
            player2.setnGolem(3);

        }if ( lDifficolta== 3 ){
            num = 9;
            Elemento.creaNuovoEquilibrio( num  );
            /*player1.nGolem.npietre = 5;
            player2.nGolem.npietre = 5;*/
            player1.setnGolem(3);
            player2.setnGolem(3);


        }


    }
    // METODO CHE RITORNA IL VINCITORE DELLA PARTITA ( quando il numero di golem e zero)
    public String vediVincitore ( ){
        if ( player1.array_golem.size()==0 ){
            return player2.getNome();
        }
        if ( player2.array_golem.size( )==0  ){
            return   player1.getNome();
    }


}
