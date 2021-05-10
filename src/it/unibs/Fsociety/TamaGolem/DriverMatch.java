package it.unibs.Fsociety.TamaGolem;

public class DriverMatch {

    public static void main(String[] args) {
        Match match;

        // creazione oggetto
        String nome = "andrea";
        int nGolem= 0 ;
        Giocatore player1 = new Giocatore(nome , nGolem);


        String nome1 = "mirko";
        int nGolem1= 0 ;
        Giocatore player2 = new Giocatore(nome1 , nGolem1);




        // creazione istanza

        match = new Match(player1, player2 , 2);

        match.scegliLivelloDifficolta(2);

        System.out.println(player1.getNome());
        System.out.println(player1.getnGolem());
        System.out.println(player2.getnGolem());

    }
}
