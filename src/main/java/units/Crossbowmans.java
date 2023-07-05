package units;

import java.util.ArrayList;
import java.util.List;

public class Crossbowmans extends Archers implements IntGame{

    public Crossbowmans(List<Unit> heroes, int x, int y) {
        super(getName(), 120, 30, 140, new int[]{55, 75}, 3,
                4, 20, 3, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
