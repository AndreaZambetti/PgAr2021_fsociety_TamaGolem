package it.unibs.Fsociety.TamaGolem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Elemento {

    private static final HashMap<Integer, Elemento> tutti_elementi = new HashMap<>();
    private static final Elemento elemento_acido = new Elemento("acido");
    private static final Elemento elemento_acqua = new Elemento("acqua");
    private static final Elemento elemento_aria = new Elemento("aria");
    private static final Elemento elemento_elettrico = new Elemento("elettrico");
    private static final Elemento elemento_forza = new Elemento("forza");
    private static final Elemento elemento_fuoco = new Elemento("fuoco");
    private static final Elemento elemento_radioso = new Elemento("radioso");
    private static final Elemento elemento_terra = new Elemento("terra");
    private static final Elemento elemento_tuono = new Elemento("tuono");
    private static final int massimo = 9;
    private static final int minimo = 0;

    private String nome;
    private ArrayList <String> elementi_deboli;
    private ArrayList <String> elementi_forti;

    public Elemento(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setElementi_deboli(ArrayList<String> elementi_deboli) {
        this.elementi_deboli = elementi_deboli;
    }

    public void setElementi_forti(ArrayList<String> elementi_forti) {
        this.elementi_forti = elementi_forti;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getElementi_deboli() {
        return elementi_deboli;
    }

    public ArrayList<String> getElementi_forti() {
        return elementi_forti;
    }

    //Genera un insieme randomico di indici per la selezione degli elementi
    public ArrayList<Integer> selezione_random(int numero_elementi){
        //Usando un set ci si assicura che ogni numero sia unico
        Set<Integer> lista_codici_elementi = new HashSet<>();

        /*Finché non sono stati generati il numero di indici richiesti il metodo
          non si interrompe.*/
        while (lista_codici_elementi.size() < numero_elementi){
            //Genera indici compresi tra 0 e 8
            int rand = (int)(Math.random() * (massimo - minimo));
            lista_codici_elementi.add(rand);
        }
        /*Non capendo se sia possibile selezionare un certo elemento del set
        * si esegue la conversione di quest'ultimo in un ArrayList per evitare il problema*/
        return new ArrayList<Integer>(lista_codici_elementi);
    }

    public HashMap<Integer, Elemento> inizializzaHashMapEquilibrio(int numero_elementi){
        HashMap<Integer, Elemento> nuovo_equilibrio = new HashMap<>();

        //Inizializzazione degli elementi.
        //Cercare di rimuoverlo da questo metodo poiché in caso di utilizzo
        //del programma per più partite può causare inutili operazioni extra.
        tutti_elementi.put(0, elemento_acido);
        tutti_elementi.put(1, elemento_acqua);
        tutti_elementi.put(2, elemento_aria);
        tutti_elementi.put(3, elemento_elettrico);
        tutti_elementi.put(4, elemento_forza);
        tutti_elementi.put(5, elemento_fuoco);
        tutti_elementi.put(6, elemento_radioso);
        tutti_elementi.put(7, elemento_terra);
        tutti_elementi.put(8, elemento_tuono);

        /*Selezione di un numero di elementi casuali richiesti.
          La selezione avviene attraverso i key dell'HashMap.*/
        ArrayList<Integer> indici_elementi_random = new ArrayList<Integer>();
        indici_elementi_random.addAll(selezione_random(numero_elementi));

        for (int i=0; i<numero_elementi; i++){
            nuovo_equilibrio.put(i, tutti_elementi.get(indici_elementi_random.get(i)));
        }

        return nuovo_equilibrio;
    }
}
