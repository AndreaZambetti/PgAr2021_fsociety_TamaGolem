package it.unibs.Fsociety.TamaGolem;

import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

/**
 * crea il giocatore
 */

public class Giocatore {

    private ArrayList<Golem> array_golem = new ArrayList<>();
    private String nome;
    private  int nGolem ;
    private int  nPietre ;



    public Giocatore(String nome) {

        this.nome = nome;
    }

    //Creato da Diego venerdì
    public Giocatore() { }

    public ArrayList<Golem> getArray_golem() {
        return array_golem;
    }

    public void setArray_golem(ArrayList<Golem> array_golem) {
        this.array_golem = array_golem;
    }

    public String getNome() {
        return nome;
    }

    //Modificato da Diego venerdì
    public void setNome1(String nome) {
        this.nome = nome;
    }

    //Modificato da Diego venerdì
    public void setNome(int i) {
        this.nome = InputDati.leggiStringa(String.format("inserisci il nome del player %d\t", i ));
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

    public String getTipoPietraGolem (int i){
        return this.getArray_golem().get(0).getArray_elementi().get(i).getNome_elemento();
    }

    /**
     *  metodo per la creazione del golem crea golem
     * @ return void
     */

    public void creaGolem(){
            for( int i= 0 ; i< nGolem; i++) {
                String nomeGolem = InputDati.leggiStringa(" inserisci il nome del golem " + (i+1) + " ");
                array_golem.add(new Golem(nomeGolem));
            }
    }


    /**
     * metodo per cambiare il golem
     * @return
     */
    public void cambiaGolem() {

        if (getArray_golem().get(0).isMorto()) {
            getArray_golem().remove(0);
        }

    }







}







