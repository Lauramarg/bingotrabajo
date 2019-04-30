package clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Carton {

    private final ArrayList<Integer> NUMEROS;
    private int tamano;

    public Carton(ArrayList<Integer> NUMEROS) {
        Collections.sort(NUMEROS);
        this.NUMEROS = NUMEROS;
        this.tamano = NUMEROS.size();
    }

    public boolean esBingo(ArrayList<Integer> bExt) {
        return NUMEROS.containsAll(bExt);
    }

    public ArrayList<Integer> getNUMEROS() {
        return NUMEROS;
    }

    public int getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return NUMEROS.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carton other = (Carton) obj;
        if (tamano != other.tamano) {
            return false;
        }
        return NUMEROS.containsAll(other.NUMEROS);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.NUMEROS);
        hash = 47 * hash + this.tamano;
        return hash;
    }
}
