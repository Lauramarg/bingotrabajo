package juegobingo;

import clases.Bingo;
import clases.BingoAmericano;
import clases.BingoClasico;
import clases.Carton;
import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {
        ArrayList<Bingo> bingos = new ArrayList<Bingo>();
        bingos.add(new BingoClasico(5));
        bingos.add(new BingoAmericano());
        ArrayList<Carton> cartonesClasicos = new ArrayList<Carton>();
        ArrayList<Carton> cartonesAmericanos = new ArrayList<Carton>();

        for (int i = 0; i < bingos.size(); i++) {
            for (int k = 0; k < 5; k++) {
                if (bingos.get(i).getClass() == BingoClasico.class) {
                    cartonesClasicos.add(bingos.get(i).generarCarton());
                } else {
                    cartonesAmericanos.add(bingos.get(i).generarCarton());
                }
            }
        }
        for (int i = 0; i < cartonesClasicos.size(); i++) {
            System.out.println(cartonesClasicos.get(i).toString());
        }
        for (int i = 0; i < cartonesAmericanos.size(); i++) {
            System.out.println(cartonesAmericanos.get(i).toString());
        }
        for (int i = 0; i < bingos.size(); i++) {
            while (bingos.get(i).finalizado) {
                System.out.println(bingos.get(i).girar());
            }
        }
    }

}
