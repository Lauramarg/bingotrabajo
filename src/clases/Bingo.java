package clases;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Bingo {

    protected final int BOLA_MAYOR;
    protected ArrayList<Integer> bombo;
    protected ArrayList<Integer> bExt;
    protected int ultB;
    protected final int TAMANO_CARTON;
    protected ArrayList<Carton> cartones;
    protected ArrayList<Carton> cartonesBingo;
    public boolean finalizado;

    public Bingo(int TAMANO_CARTON, int BOLA_MAYOR) {
        this.TAMANO_CARTON = TAMANO_CARTON;
        this.BOLA_MAYOR = BOLA_MAYOR;
        bombo = new ArrayList<Integer>();
        for (int i = 1; i <= BOLA_MAYOR; i++) {
            bombo.add(i);
        }
        bExt = new ArrayList<Integer>();
        ultB = 0;

        cartones = new ArrayList<Carton>();
        cartonesBingo = new ArrayList<Carton>();
        finalizado = false;
    }

    public Integer girar() {
        Collections.shuffle(bombo);
        ultB = bombo.get(0);
        bExt.add(bombo.get(0));
        bombo.remove(0);
        for (int i = 0; i < cartones.size(); i++) {
            if (cartones.get(i).esBingo(bExt)) {
                cartonesBingo.add(cartones.get(i));
                this.finalizado = true;
            }
        }
        return ultB;
    }

    public ArrayList<Carton> getCartones() {
        return cartones;
    }

    public Carton generarCarton() {
        ArrayList<Integer> numerosP = new ArrayList<Integer>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        Carton c;
        do {
            for (int i = 1; i <= BOLA_MAYOR; i++) {
                numerosP.add(i);
            }
            Collections.shuffle(numerosP);
            for (int i = 1; i <= TAMANO_CARTON; i++) {
                numeros.add(numerosP.get(i));
            }
            c = new Carton(numeros);

        } while (aceptable(c) && cartones.contains(c));
        cartones.add(c);
        return c;

    }

    public int getBOLA_MAYOR() {
        return BOLA_MAYOR;
    }

    public ArrayList<Integer> getBombo() {
        return bombo;
    }

    public ArrayList<Integer> getbExt() {
        return bExt;
    }

    public int getUltB() {
        return ultB;
    }

    public int getTAMANO_CARTON() {
        return TAMANO_CARTON;
    }

    public ArrayList<Carton> getCartonesBingo() {
        return cartonesBingo;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public abstract boolean aceptable(Carton c);
}
