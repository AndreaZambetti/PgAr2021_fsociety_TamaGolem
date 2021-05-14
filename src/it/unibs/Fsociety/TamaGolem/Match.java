package it.unibs.Fsociety.TamaGolem;
import it.unibs.fp.mylib.InputDati;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * racchiude tutti gli elementi del match
 */
public class Match {
    public static final String ELEMENTI_AGGIUNTI = "\n\nQuesti sono gli elementi aggiunti al golem %s del giocatore %s: ";
    public static final String INSERISCI_LA_PIETRA = "%s inserisci la nuova pietra per il tuo golem: ";
    public static final String SCEGLI_IL_NUMERO_DELLA_PIETRA = "Scegli il numero della pietra: ";
    public static final String INSERISCI_I_GOLEM_DEL_GIOCATORE = "%s inserisci i nomi per i tuoi golem: ";
    public static final String PIETRE_RIMASTE_NELLA_SCORTA = "\nLa scorta contiene: ";
    public static final String VITA_DEL_GOLEM = "Vita del golem %s del giocatore %s";
    public static final String SCEGLI_IL_LIVELLO_DELLA_PARTITA = "Scegliete il livello della partita\n" +
            "1) facile (5 elementi)\n" +
            "2) medio(7 elementi)\n" +
            "3) difficile (9 elementi)\n" +
            "Insersci il livello di difficolta che preferisci: ";
    public static final String VINITO_DA_S_DEL_GIOCATORE_S = " lo scontro e` stato vinto da %s del giocatore %s";
    public static final String ATTACCOGOLEMPIETRA = "attacco: golem %s    pietra %s ";
    public static final String PROCEDERE = "Procedere? ";
    public static final String VOLETE_CONTINUARE_A_GIOCARE = "Volete continuare a giocare? ";
    public static final String OTTIMO_PROCEDIAMO = "OTTIMO! Procediamo\n\n";
    public static final String PECCATO_SARÀ_PER_UN_ALTRA_VOLTA = "Peccato, sarà per un'altra volta";

    private boolean conclusa = false;
    private Giocatore player1;
    private Giocatore player2;
    private int lDifficolta;
    private Equilibrio equilibrio;
    private ArrayList<Elemento> scortaPietre;

    public Match() {

        Giocatore player1 = new Giocatore();
        Giocatore player2 = new Giocatore();
        player1.setNome(1);
        player2.setNome(2);

        this.player1 = player1;
        this.player2 = player2;
        this.scortaPietre = new ArrayList<Elemento>();

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

    public Equilibrio getCreaEquilibrio() {
        return equilibrio;
    }

    public void setCreaEquilibrio(Equilibrio creaEquilibrio) {
        this.equilibrio = creaEquilibrio;
    }

    public Equilibrio getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(Equilibrio equilibrio) {
        this.equilibrio = equilibrio;
    }

    public ArrayList<Elemento> getScortaPietre() {
        return scortaPietre;
    }

    public void setScortaPietre(ArrayList<Elemento> scortaPietre) {
        this.scortaPietre = scortaPietre;
    }

    /**
     * metodo  per scegliere il livello di difficolta
     * @param lDifficolta
     * @return void
     */
    public void scegliLivelloDifficolta(int lDifficolta) {
        Elemento.riempi_tutti_elementi();

        switch (lDifficolta) {
            case 1:
                // 3 pietre per ogni elemento

                equilibrio = Equilibrio.genera_equilibrio(5);
                int key1;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 3; j++) {
                        key1 = i * 3 + j;
                        scortaPietre.add( equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                player1.setnGolem(2);
                player2.setnGolem(2);
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE,player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE , player2.getNome()));
                player2.creaGolem();
                for (int i = 0; i < player1.getArray_golem().size(); i++) {
                    player1.setnPietre(3);
                    player2.setnPietre(3);
                }
                break;

            case 2:
                // 4 pietre per ogni elemento

                equilibrio = Equilibrio.genera_equilibrio(7);
                int key2;
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 4; j++) {
                        key2 = i * 4 + j;
                        scortaPietre.add( equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                // creazione del numero preciso di golem
                player1.setnGolem(3);
                player2.setnGolem(3);
                //creazione golem

                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player2.getNome()));
                player2.creaGolem();

                player1.setnPietre(4);
                player2.setnPietre(4);

                break;

            case 3:
                // 5 pietre per ogni elemento

                equilibrio = Equilibrio.genera_equilibrio(9);
                int key3;
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 5; j++) {
                        key3 = i * 5 + j;
                        scortaPietre.add( equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                player1.setnGolem(4);
                player2.setnGolem(4);
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player2.getNome()));
                player2.creaGolem();
//set numero di pietre
                player1.setnPietre(5);
                player2.setnPietre(5);

                break;
        }

    }

    /**
     * viene richiamata nel main e si usa per andare e vedere chi e il vincitore
     * @return vincitore
     */
    public void vediVincitore() {
        if (player1.getArray_golem().size()==0) {

            System.out.println(String.format("Congratulazioni!\n%s sei il vincitore\n%s andrà meglio la prossima volta",
                    player2.getNome(), player1.getNome()));

        }
        else if (player2.getArray_golem().size()==0) {

            System.out.println(String.format("Congratulazioni!\n%s sei il vincitore\n%s andrà meglio la prossima volta",
                    player1.getNome(), player2.getNome()));
        }
    }

    /**
     * metodo utilizzato per andare a sostituire il pockemon alla sua morte
     * @return void
     * @param golemUtilizzato
     */
    public void evoluzione(int golemUtilizzato) {

        // aggiunta pietre player 1 se  il golem e senza pietre
        if(!player1.getArray_golem().isEmpty()) {

            if (player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
                System.out.println(String.format(VINITO_DA_S_DEL_GIOCATORE_S,player2.getArray_golem().get(golemUtilizzato).getNome(),player2.getNome()));
                for (int i = 0; i < player1.getnPietre(); i++) {

                    stampaPietreScorta();

                    System.out.println(String.format(INSERISCI_LA_PIETRA, player1.getNome()));
                    int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 1, scortaPietre.size()) - 1;
                    player1.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                    scortaPietre.remove(pietraInserire);

                    //stampa
                    System.out.println(String.format(ELEMENTI_AGGIUNTI, player1.getArray_golem().get(0).getNome(), player1.getNome()));
                    for (int j = 0; j < player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                        System.out.println(player1.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());
                    }
                    System.out.println("\n\n");
                }
            }

        }

        //aggiunta pietre player 2 se il golem e senza pietre
        if(!player2.getArray_golem().isEmpty()) {
            if (player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
                System.out.println(String.format(VINITO_DA_S_DEL_GIOCATORE_S,player1.getArray_golem().get(golemUtilizzato).getNome(),player1.getNome()));

                for (int i = 0; i < player2.getnPietre(); i++) {

                    stampaPietreScorta();

                    System.out.println(String.format(INSERISCI_LA_PIETRA, player2.getNome()));
                    int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 1, scortaPietre.size()) - 1;
                    player2.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                    scortaPietre.remove(pietraInserire);

                    //stampa
                    System.out.println(String.format(ELEMENTI_AGGIUNTI, player2.getArray_golem().get(0).getNome(), player2.getNome()));
                    for (int j = 0; j < player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                        System.out.println(player2.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());
                    }
                    System.out.println("\n\n");
                }
            }

        }

    }

    /**
     * metodo per la batttaglia tra 2 pockemon
     * @return void
     */
    public void battagliaGolem () throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            // indici delle pietre
            // pietra player 1
            int i = -1;
            //pietra player 2
            int j = -1;
            int indice_elemento_primo_golem = 0;
            int indice_elemento_secondo_golem = 0;

            do {
                // switch di  pietre
                i = player1.getArray_golem().get(0).switchPietre(i);
                j = player2.getArray_golem().get(0).switchPietre(j);

                for (int index = 0; index <equilibrio.getElementi_equilibrio().size(); index++) {
                    if (equilibrio.getNomeElementoEquilibrio(index).equals(player2.getTipoPietraGolem(i))) {
                        indice_elemento_secondo_golem = index;
                    }
                    if (equilibrio.getNomeElementoEquilibrio(index).equals(player1.getTipoPietraGolem(i))) {
                        indice_elemento_primo_golem = index;

                    }

                }
                /**Danno delle pietre: andando a leggere il valore presente nella tabella,
                 * in caso sia diverso da 0, segna i danni nella vita del golem*/
                player1.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                        get_adiacenza(indice_elemento_primo_golem, indice_elemento_secondo_golem));
                player2.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                        get_adiacenza(indice_elemento_secondo_golem, indice_elemento_primo_golem));

                // stampa
                System.out.println(String.format(ATTACCOGOLEMPIETRA,
                        player1.getArray_golem().get(0).getNome(),player1.getArray_golem().get(0).getArray_elementi().get(i).getNome_elemento()));
                System.out.println(String.format(ATTACCOGOLEMPIETRA,
                           player2.getArray_golem().get(0).getNome(),player2.getArray_golem().get(0).getArray_elementi().get(j).getNome_elemento()));
                System.out.println("\n");
                //stampa vita
                System.out.println(String.format(VITA_DEL_GOLEM,player1.getArray_golem().get(0).getNome() , player1.getNome() ));
                System.out.println(player1.getArray_golem().get(0).getVita());
                System.out.println(String.format(VITA_DEL_GOLEM,player2.getArray_golem().get(0).getNome() , player2.getNome() ));
                System.out.println(player2.getArray_golem().get(0).getVita());

                System.out.println("Premere il tasto invio  per continuare");
                br.readLine();

                


            } while (!player2.getArray_golem().get(0).isMorto() && !player1.getArray_golem().get(0).isMorto());

    }

    /**
     * metodo per la stampa delle pietre
     * @return void
     */
    private void stampaPietreScorta(){

        System.out.println(PIETRE_RIMASTE_NELLA_SCORTA);

        int indice;
        for (int i = 0; i < scortaPietre.size(); i++) {
            if(i != 0 && !scortaPietre.get(i).getNome_elemento().equals(scortaPietre.get(i-1).getNome_elemento()))
                System.out.println();
            indice = i + 1;
            System.out.print(indice + ": " + scortaPietre.get(i).getNome_elemento() + ";\t");
        }
        System.out.println();
    }

    /**
     * metodo per ricomincaire la partita
     * @return boolean
     *
     */
    public static boolean continuaGioco(){
        boolean continua = InputDati.yesOrNo(VOLETE_CONTINUARE_A_GIOCARE);
        if (continua){
            System.out.println(OTTIMO_PROCEDIAMO);
        } else {
            System.out.println(PECCATO_SARÀ_PER_UN_ALTRA_VOLTA);
        }
        return continua;
    }

    /**
     * metodo partita
     * @return void
     */
    public void partita() throws IOException {
        int livello = InputDati.leggiIntero(SCEGLI_IL_LIVELLO_DELLA_PARTITA, 1, 3);
        this.scegliLivelloDifficolta(livello);
        this.evoluzione(0);

        do {
            boolean attacco = InputDati.yesOrNo(PROCEDERE);
            this.battagliaGolem();


            this.getPlayer1().cambiaGolem();
            this.evoluzione(0);
            this.getPlayer2().cambiaGolem();
            this.evoluzione(0);

        } while (!this.getPlayer1().getArray_golem().isEmpty() && !this.getPlayer2().getArray_golem().isEmpty());

        this.vediVincitore();
        this.getEquilibrio().stampaEquilibrio();
    }



}
