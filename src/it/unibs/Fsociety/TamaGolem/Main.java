package it.unibs.Fsociety.TamaGolem;

public class Main {

    public static void main(String[] args) {
        boolean continua_gioco = true;

        while (continua_gioco){
            Match match = new Match();
            match.partita();
            continua_gioco = Match.continuaGioco();
        }
    }
}