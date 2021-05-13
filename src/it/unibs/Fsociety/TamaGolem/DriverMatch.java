package it.unibs.Fsociety.TamaGolem;

public class DriverMatch {

    public static void main(String[] args) {
        Match match;

        // creazione oggetto
        String nome = "andrea";

        Giocatore player1 = new Giocatore(nome);


        String nome1 = "mirko";

        Giocatore player2 = new Giocatore(nome1);




        // creazione istanza

        match = new Match(player1, player2 );


        match.scegliLivelloDifficolta(2);

        // visualizzazione delle pietre di scorta

        match.evoluzione(0);

        match.battagliaGolem();


        // scelta pietre

    }
}
