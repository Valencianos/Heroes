package units;


public class Snipers extends Archers implements IntGame {

    public Snipers(int x, int y) {
        super(getName(), 100, 20, 100, new int[]{50, 70}, 5, 6, 30, 4, x, y);
    }

}
