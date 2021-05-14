package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class Giocatore {

    private ArrayList<Golem> array_golem = new ArrayList<>();
    private String nome;
    private  int nGolem ;
    private int  nPietre ;



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
    public int getnPietre() {
        return nPietre;
    }

    public void setnPietre(int nPietre) {
        this.nPietre = nPietre;
    }

// ho tolto il for per provare a fare una cosa



    public void creaGolem(){
            for( int i= 0 ; i< nGolem; i++) {
                String nomeGolem = InputDati.leggiStringa(" inserisci il nome del golem " + (i+1) + " ");
                array_golem.add(new Golem(nomeGolem));
            }
    }


    // METODO CHE VA A CAMBIARE IL GOLEM  (i = golem player 1  j = golem player 2)
    public void cambiaGolem() {

        if (getArray_golem().get(0).isMorto()) {
            getArray_golem().remove(0);
        }

    }







}







