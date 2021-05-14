package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;



public class Main {

    public static final String SCEGLI_IL_LIVELLO_DELLA_PARTITA = "scegli il livello della partita\n1) facile\n2) medio\n3) difficile\n" +
            "insersci il livello di difficolta che preferisci ";

    //CREAZIONE DEL OGGETTO
    public static Giocatore creaGiocatore(int i) {
        String nome = InputDati.leggiStringa(String.format("inserisci il nome del player %d\t", i ));
        return new Giocatore(nome);
    }

    public static void main(String[] args) {
        Match match;
        Equilibrio equilibrio = new Equilibrio();

        //creazione 2 giocatori
        Giocatore player1 = creaGiocatore(1);
        Giocatore player2 = creaGiocatore(2);

        //CREAZIONE LIVELLO
        match = new Match(player1, player2);
        int livello = InputDati.leggiIntero(SCEGLI_IL_LIVELLO_DELLA_PARTITA, 1, 3);
        match.scegliLivelloDifficolta(livello);
        match.evoluzione(0);
        //METODO BATTAGLIA
        do {
            // scelta pietra

            boolean attacco = InputDati.yesOrNo("vuoi attaccare ");
            match.battagliaGolem();

            player1.cambiaGolem();
            match.evoluzione(0);
            player2.cambiaGolem();
            match.evoluzione(0);

        }while (!player1.getArray_golem().isEmpty() && !player2.getArray_golem().isEmpty());
        //visualizza il vincitore
        match.vediVincitore();
        match.getEquilibrio().stampaEquilibrio();


    }
}