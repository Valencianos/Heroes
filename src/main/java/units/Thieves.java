package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thieves extends Infantries{

    public Thieves(List<Unit> heroes, int x, int y){
        super(getName(), 120, 40, 200, new int[]{15,30}, 8, 6, 20, x, y);
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}
