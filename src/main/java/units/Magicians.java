package units;

import java.util.ArrayList;
import java.util.List;

public class Magicians extends Wizards {

    public Magicians(List<Unit> heroes, int x, int y) {
        super(getName(), 70, 30, 150, new int[]{35, 55}, 4, 5, 20, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
