package it.unibs.Fsociety.TamaGolem;

public class Golem {
    private String  nome;
    private int vita ;
    private int nPietre;

    public Golem(String nome) {
        this.nome = nome;
        this.vita = vita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnPietre() {
        return nPietre;
    }


    public void setnPietre(int nPietre) {
        this.nPietre = nPietre;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }
}
