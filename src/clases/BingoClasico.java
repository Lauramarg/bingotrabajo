package clases;

public class BingoClasico extends Bingo {

    private int limite;

    public BingoClasico(int limite) {
        super(15, 90);
        this.limite = limite;
        cartones.ensureCapacity(limite);
        cartonesBingo.ensureCapacity(limite);
    }

    @Override
    public boolean aceptable(Carton c) {
        int a = c.getNUMEROS().get(0);
        for (int i = 1; i < c.getNUMEROS().size(); i++) {
            if (a + 1 == c.getNUMEROS().get(i)) {
                return false;
            }
            a = c.getNUMEROS().get(i);
        }
        return true;
    }

    public int getFaltantes() {
        return limite - cartones.size();
    }
}
