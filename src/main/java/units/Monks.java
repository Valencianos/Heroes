package units;

import java.util.ArrayList;
import java.util.List;

public class Monks extends Wizards{

    public Monks(List<Unit> heroes, int x, int y) {
        super(getName(), 60, 40, 150, new int[]{30, 50}, 5, 4, 30, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
