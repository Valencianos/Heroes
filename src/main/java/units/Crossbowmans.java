package units;


public class Crossbowmans extends Archers implements IntGame{

    public Crossbowmans(int x, int y) {
        super(getName(), 120, 30, 140, new int[]{55, 75}, 3,
                4, 20, 3, x, y);
    }

}
