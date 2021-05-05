package it.unibs.Fsociety.TamaGolem;

import java.io.OutputStream;
import java.util.*;

public class Main {

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

    public static void main(String[] args) {
	// write your code here

        int numero_elementi = 5;
        HashMap<Integer, Elemento> equilibrio = new HashMap();

        /*Ciclo for che esegue il test della selezione degli elementi per più partite.
        * ELIMINARE ALLA CONCLUSIONE DELLE PROVE*/
        /*for (int j=0; j<10; j++) {
            System.out.println("Nuova prova del metodo");
            equilibrio.putAll(inizializzaEquilibrio(numero_elementi));
            for (int i = 0; i < equilibrio.size(); i++) {
                System.out.println(equilibrio.get(i).getNome());
            }
            System.out.print("\n");
            equilibrio.clear();
        }*/
    }
}
