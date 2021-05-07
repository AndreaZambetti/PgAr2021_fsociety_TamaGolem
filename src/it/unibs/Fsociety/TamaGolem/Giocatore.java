package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;

public class Giocatore {

    private String   nome;
    private int  nGolem;
    private ArrayList<Golem> Array_golem = new ArrayList<>() ;


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

    public ArrayList<Golem> getArray_golem() {
        return setArray_golem;
    }

    public void setArray_golem(ArrayList<Golem> setArray_golem) {
        this.setArray_golem = setArray_golem;
    }

    public void setnGolem(int nGolem) {
        this.nGolem = nGolem;
    }
    //  CREAZIONE GOLEM
    public void creazioneGolem ( ){
        String nome = "ciao";


        setArray_golem.add(new Golem (nome));
    }


}
