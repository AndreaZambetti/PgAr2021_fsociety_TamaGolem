package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;

public class Giocatore {

    private ArrayList<Golem> array_golem = new ArrayList<>();

    private String nome;

    public Giocatore(ArrayList<Golem> array_golem, String nome) {
        this.array_golem = array_golem;
        this.nome = nome;
    }

    public ArrayList<Golem> getArray_golem() {
        return array_golem;
    }

    public void setArray_golem(ArrayList<Golem> array_golem) {
        this.array_golem = array_golem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnGolem() {
        return this.array_golem.size();
    }





}

