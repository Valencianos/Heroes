package units;

import java.util.ArrayList;
import java.util.List;

public class Spearmans extends Infantries{

    public Spearmans(List<Unit> heroes, int x, int y) {
        super(getName(), 80, 50, 250, new int[]{20,40}, 6, 4, 30, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
