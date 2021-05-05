package it.unibs.Fsociety.TamaGolem;

import java.lang.reflect.Array;

public class Giocatore {

    private String   nome;
    private int  nGolem;


    public Giocatore(String nome, int nGolem) {
        this.nome = nome;
        this.nGolem = nGolem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnGolem() {
        return nGolem;
    }

    public void setnGolem(int nGolem) {
        this.nGolem = nGolem;
    }
}
