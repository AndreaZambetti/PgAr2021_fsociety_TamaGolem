package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;

public class Golem {

    private static final int MAX_VITA = 30;

    private ArrayList <Elemento> array_elementi;
    private String nome;
    private int vita ;
    private boolean morto =  false;


    public Golem( String nome) {
        this.array_elementi = new ArrayList<>();
        /*this.pietre = pietre;*/
        this.nome = nome;
        this.setVita(MAX_VITA);
        this.setMorto(false);
    }

    public ArrayList<Elemento> getArray_elementi() {
        return array_elementi;
    }

    public void setArray_elementi(ArrayList<Elemento> array_elementi) {
        this.array_elementi = array_elementi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVita() {
        return vita;
    }



    public void setVita(int vita) {
        if(vita <= 0) {
            this.vita = 0;
            this.setMorto(true);
        } else {
            this.vita = vita;
        }

    }

    public int getNumeroPietre() {
        return this.array_elementi.size();
    }

    public void setMorto(boolean morto) {
        this.morto = morto;
    }

    public boolean isMorto(){
        return this.morto;
    }


    public int togliVita(int danno){

        this.setVita(this.vita - danno);
        return this.vita;
    }

    // quando il giocatore  la richiama andiamo a cambiargl lo la pietra
    public int  switchPietre(int i ){
        i++;
        if ( i >= array_elementi.size()){
            i=0;

        }
        return i;
    }











}
