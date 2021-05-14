package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;


import java.util.ArrayList;
import java.util.HashMap;

// step uno capire cosa passargli
public class Match {
    public static final String ELEMENTI_AGGIUNTI = "\n\nquesti sono gli elementi aggiunti al golem %s del giocatore %s";
    public static final String INSERISCI_LA_PIETRA = "inserisci la pietra di %s";
    public static final String SCEGLI_IL_NUMERO_DELLA_PIETRA = "scegli il numero della pietra ";
    public static final String INSERISCI_I_GOLEM_DEL_GIOCATORE = "inserisci i nomi del  golem del giocatore %s ";
    public static final String PIETRE_RIMASTE_NELLA_SCORTA = "\npietre rimaste nella scorta";
    public static final String VITA_DEL_GOLEM = "vita del golem %s del giocatore %s";


    private boolean conclusa = false;
    private Giocatore player1;
    private Giocatore player2;
    private int lDifficolta;
    private Equilibrio equilibrio;
    private ArrayList<Elemento> scortaPietre = new ArrayList<>();


    public Match(Giocatore player1, Giocatore player2) {

        this.player1 = player1;
        this.player2 = player2;


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


    // METODO CHE RITORNA IL VINCITORE DELLA PARTITA ( quando il numero di golem e zero)
    // quando la andremo a dichiarare nel main andra richiamata la classe vincitore e se
    // la classe vincirore e uguale  non e vuota allora pesiste il vincitore e si fermera il ciclo
    public void vediVincitore() {
        if (player1.getArray_golem().size()<=0) {

            System.out.println(String.format(" il vincitore e %s", player2.getNome()));

        }
        if (player2.getArray_golem().size()<=0) {

            System.out.println(String.format(" il vincitore e %s", player1.getNome()));
        }
    }







// DA FARE
    // AGGIUNTA PITRRE AL GOLEM CHE LO STA RICHIAMANDO

    public void evoluzione(int golemUtilizzato) {
        // visualizzazione di tutte le pietre

        // aggiunta pietre player 1 se  il golem e senza pietre
        if (player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
            for (int i = 0 ; i< scortaPietre.size(); i++) {
                System.out.println(i +" "+ scortaPietre.get(i).getNome_elemento());
            }
            for (int i = 0; i < player1.getnPietre(); i++) {
                System.out.println(String.format(INSERISCI_LA_PIETRA, player1.getNome()));
                int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 0,scortaPietre.size()-1);
                player1.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                scortaPietre.remove(pietraInserire);

                //stampa
                System.out.println(String.format(ELEMENTI_AGGIUNTI, player1.getArray_golem().get(0).getNome(), player1.getNome()));
                for (int j = 0; j < player1.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                    System.out.println(player1.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());
                }
                System.out.println("\n\n\n\n\n\n");

                // mostra piu volte

                System.out.println(PIETRE_RIMASTE_NELLA_SCORTA);
                for (int s = 0; s < scortaPietre.size(); s++) {
                    System.out.println(s +" "+ scortaPietre.get(s).getNome_elemento());
                }
            }
            //aggiunta pietre player 2 se il golem e senza pietre
            if (player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size() == 0) {
                for (int i = 0 ; i< scortaPietre.size(); i++) {
                    System.out.println(i +" "+ scortaPietre.get(i).getNome_elemento());
                }
                for (int i = 0; i < player2.getnPietre(); i++) {
                    System.out.println(String.format(INSERISCI_LA_PIETRA, player2.getNome()));
                    int pietraInserire = InputDati.leggiIntero(SCEGLI_IL_NUMERO_DELLA_PIETRA, 0,scortaPietre.size()-1);
                    player2.getArray_golem().get(golemUtilizzato).getArray_elementi().add(scortaPietre.get(pietraInserire));
                    scortaPietre.remove(pietraInserire);

                    //stampa
                    System.out.println(String.format(ELEMENTI_AGGIUNTI, player2.getArray_golem().get(0).getNome(), player2.getNome()));
                    for (int j = 0; j < player2.getArray_golem().get(golemUtilizzato).getArray_elementi().size(); j++) {
                        System.out.println(player2.getArray_golem().get(golemUtilizzato).getArray_elementi().get(j).getNome_elemento());

                    }
                    // mostra piu volte
                    System.out.println(PIETRE_RIMASTE_NELLA_SCORTA);

                    for (int s = 0; s < scortaPietre.size(); s++) {
                        System.out.println(s +" "+ scortaPietre.get(s).getNome_elemento());
                    }
                }
            }
        }
    }

//metodo per l'attacco tra pietre e restituisce il danno

    public void battagliaGolem () {
            // indici delle pietre
            // pietra player 1
            int i = -1;
            //pietra player
            int j = -1;
            int indice_elemento_primo_golem = 0;
            int indice_elemento_secondo_golem = 0;

            do {
                // switch di  pietre
                i = player1.getArray_golem().get(0).switchPietre(i);
                j = player2.getArray_golem().get(0).switchPietre(j);

                for (int index = 0; index <equilibrio.getElementi_equilibrio().size(); index++) {
                    if (equilibrio.getElementi_equilibrio().get(index).getNome_elemento().equals(player2.getArray_golem().get(0).getArray_elementi().get(i).getNome_elemento())) {
                        indice_elemento_secondo_golem = index;
                    }
                    if (equilibrio.getElementi_equilibrio().get(index).getNome_elemento().equals(player1.getArray_golem().get(0).getArray_elementi().get(j).getNome_elemento())) {
                        indice_elemento_primo_golem = index;

                    }

                }
                /*Danno delle pietre: andando a leggere il valore presente nella tabella,
                 * in caso sia diverso da 0, segna i danni nella vita del golem*/
                player1.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                        get_adiacenza(indice_elemento_primo_golem, indice_elemento_secondo_golem));
                player2.getArray_golem().get(0).togliVita(equilibrio.getInterazione_elementi().
                        get_adiacenza(indice_elemento_secondo_golem, indice_elemento_primo_golem));
                // stampa vita

                System.out.println(String.format(VITA_DEL_GOLEM,player1.getArray_golem().get(0).getNome() , player1.getNome() ));
                System.out.println(player1.getArray_golem().get(0).getVita());
                System.out.println(String.format(VITA_DEL_GOLEM,player2.getArray_golem().get(0).getNome() , player2.getNome() ));
                System.out.println(player2.getArray_golem().get(0).getVita());

            } while (!player2.getArray_golem().get(0).isMorto() && !player1.getArray_golem().get(0).isMorto());

    }









//fine

}


