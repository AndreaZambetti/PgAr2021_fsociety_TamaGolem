package it.unibs.Fsociety.TamaGolem;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean continua_gioco = true;

        while (continua_gioco){
            Match match = new Match();
            match.partita();
            continua_gioco = Match.continuaGioco();
        }
    }
}