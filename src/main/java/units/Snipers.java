package units;

import java.util.ArrayList;
import java.util.List;

public class Snipers extends Archers implements IntGame {


    public Snipers(List<Unit> heroes, int x, int y) {
        super(getName(), 100, 20, 100, new int[]{50, 70}, 5, 6, 30, 4, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
