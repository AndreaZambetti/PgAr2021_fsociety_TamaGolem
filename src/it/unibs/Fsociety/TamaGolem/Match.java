package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;

import java.util.HashMap;

// step uno capire cosa passargli
public class Match {
    public static final String ELEMENTI_AGGIUNTI = " elementi aggiunti al %s";
    public static final String INSERISCI_LA_PIETRA = "inserisci la pietra del %s";
    public static final String SCEGLI_IL_NUMERO_DELLA_PIETRA = " scegli il numero della pietra ";
    public static final String INSERISCI_I_GOLEM_DEL_GIOCATORE = " inserisci i %i golem del giocatore %s ";


    private String vincitore = "";
    private boolean conclusa = false;
    private Giocatore player1;
    private Giocatore player2;
    private int lDifficolta;
    private Equilibrio equilibrio;
    private static HashMap<Integer, Elemento> scortaPietre = new HashMap<>();


    public Match(Giocatore player1, Giocatore player2) {

        this.player1 = player1;
        this.player2 = player2;


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

    public Equilibrio getCreaEquilibrio() {
        return equilibrio;
    }

    public void setCreaEquilibrio(Equilibrio creaEquilibrio) {
        this.equilibrio = creaEquilibrio;
    }

    public HashMap<Integer, Elemento> getScortaPietre() {
        return scortaPietre;
    }

    public void setScortaPietre(HashMap<Integer, Elemento> scortaPietre) {
        this.scortaPietre = scortaPietre;
    }
// CREAZIONE LIVELLO DIFFICOLTA
    /*
     * creazione persona nel main vero
     * manca la vita ( bisogna vedere i valori di potenza di ogni difficolta quando li creeremo  )
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
                        scortaPietre.put(key1, equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                player1.setnGolem(2);
                player2.setnGolem(2);
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player1.getnGolem(), player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player2.getnGolem(), player2.getNome()));
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
                        scortaPietre.put(key2, equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                // creazione del numero preciso di golem
                player1.setnGolem(3);
                player2.setnGolem(3);
                //creazione golem

                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player1.getnGolem(), player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player2.getnGolem(), player2.getNome()));
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
                        scortaPietre.put(key3, equilibrio.getElementi_equilibrio().get(i));
                    }
                }
                player1.setnGolem(4);
                player2.setnGolem(4);
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player1.getnGolem(), player1.getNome()));
                player1.creaGolem();
                System.out.println(String.format(INSERISCI_I_GOLEM_DEL_GIOCATORE, player2.getnGolem(), player2.getNome()));
                player2.creaGolem();
//set numero di pietre
                player1.setnPietre(5);
                player2.setnPietre(5);

                break;
        }

    }


    // METODO CHE RITORNA IL VINCITORE DELLA PARTITA ( quando il numero di golem e zero)
    // quando la andremo a dichiarare nel main andra richiamata la classe vincitore e se
    // la classe vincirore e uguale  non e vuota allora pesiste il vincitore e si fermera il ciclo
    public void vediVincitore() {
        if (player1.getArray_golem().size() == 0) {
            vincitore = player1.getNome();
        }
        if (player2.getArray_golem().size() == 0) {
            vincitore = player1.getNome();
        }
    }




  /*  // METODO CHE VA A CAMBIARE IL GOLEM  (i = golem player 1  j = golem player 2)
    public void cambiaGolem() {

        if (player1.getArray_golem().get(0).isMorto() == true) {
            player1.getArray_golem().remove(0);

        }
        if (player2.getArray_golem().get(0).isMorto() == true) {
            player2.getArray_golem().remove(0);
        }
    }*/


// DA FARE
    // AGGIUNTA PITRRE AL GOLEM CHE LO STA RICHIAMANDO

    public void evoluzione(int golemUtilizzato) {
        // visualizzazione di tutte le pietre

        // aggiunta pietre player 1 se  il golem e senza pietre
        if (player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
            for (int i : scortaPietre.keySet()) {
                System.out.println(i + " " + scortaPietre.get(i).getNome_elemento());
            }
            for (int i = 0; i < player1.getnPietre(); i++) {
                System.out.println(String.format(INSERISCI_LA_PIETRA, player1.getNome()));
                int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 0, scortaPietre.keySet().size());
                player1.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                scortaPietre.remove(pietraInserire);

                //stampa
                System.out.println(String.format(ELEMENTI_AGGIUNTI, player1.getNome()));
                for (int j = 0; j < player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                    System.out.println(player1.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());
                }
                System.out.println("\n\n\n\n\n\n");
                // mostra piu volte
                for (int s : scortaPietre.keySet()) {
                    System.out.println(s + " " + scortaPietre.get(s).getNome_elemento());
                }
            }
        }
        //aggiunta pietre player 2 se il golem e senza pietre
        if (player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
            for (int i : scortaPietre.keySet()) {
                System.out.println(i + " " + scortaPietre.get(i).getNome_elemento());
            }
            for (int i = 0; i < player2.getnPietre(); i++) {
                System.out.println(String.format(INSERISCI_LA_PIETRA, player2.getNome()));
                int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 0, scortaPietre.keySet().size());
                player2.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                scortaPietre.remove(pietraInserire);

                //stampa
                System.out.println(String.format(ELEMENTI_AGGIUNTI, player2.getNome()));
                for (int j = 0; j < player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                    System.out.println(player2.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());

                }
                // mostra piu volte
                for (int s : scortaPietre.keySet()) {
                    System.out.println(s + " " + scortaPietre.get(s).getNome_elemento());
                }
            }
        }
    }

//metodo per l'attacco tra pietre e restituisce il danno


    public void battagliaGolem() {
        // indici delle pietre
        // pietra player 1
        int i = 0;
        //pietra player
        int j = 0;
        int indice_elemento_primo_golem = 0;
        int indice_elemento_secondo_golem = 0;

        do {
            for (int index = 0; index < equilibrio.getElementi_equilibrio().size(); index++) {
                if (equilibrio.getElementi_equilibrio().get(index).getNome_elemento().
                        equals(player1.getArray_golem().get(0).getArray_elementi().get(i))) {
                    indice_elemento_primo_golem = index;

                }
                if (equilibrio.getElementi_equilibrio().get(index).getNome_elemento().
                        equals(player2.getArray_golem().get(0).getArray_elementi().get(j))) {
                    indice_elemento_secondo_golem = index;
                }
            }
            // danno delle pietre
            //Andando a leggere il valore presente nella tabella
            player1.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                    get_adiacenza(indice_elemento_primo_golem, indice_elemento_secondo_golem));
            player2.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                    get_adiacenza(indice_elemento_secondo_golem, indice_elemento_primo_golem));

            // switch di  pietre
            player1.getArray_golem().get(0).switchPietre(i);
            player2.getArray_golem().get(0).switchPietre(j);
        } while (!player1.getArray_golem().get(0).isMorto() && !player2.getArray_golem().get(0).isMorto());
        player2.cambiaGolem();
        player1.cambiaGolem();
    }
}