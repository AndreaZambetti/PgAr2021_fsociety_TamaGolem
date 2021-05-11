package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Giocatore {

    private ArrayList<Golem> array_golem = new ArrayList<>();
    private String nome;
    private  int nGolem ;



    public Giocatore(String nome) {

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

    public void setnGolem(int nGolem) {
        this.nGolem = nGolem;
    }


    public void creaGolem(){
        for ( int i = 0 ; i< nGolem ; i++){
            String nomeGolem = InputDati.leggiStringa(" inserisci il nome del golem " + (i+1) + " ");
            array_golem.add(new Golem(nomeGolem));
        }
    }





}

