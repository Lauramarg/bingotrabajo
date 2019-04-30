package clases;

public class BingoAmericano extends Bingo {

    public BingoAmericano() {
        super(25, 75);
    }

    @Override
    public boolean aceptable(Carton c) {
        Integer sum = 0;
        for (int i = 0; i < c.getNUMEROS().size(); i++) {
            sum = sum + c.getNUMEROS().get(i);
        }
        sum = sum / c.getNUMEROS().size();

        return sum <= 50;
    }

}
