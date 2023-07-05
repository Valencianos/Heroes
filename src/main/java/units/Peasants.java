package units;

import java.util.ArrayList;
import java.util.List;

public class Peasants extends Unit implements IntGame{

    public int capacity;

    public Peasants(List<Unit> heroes, int x, int y) {
        super(getName(), 10, 20, 80, new int[]{5, 10}, 8, 8, x, y);
        this.capacity = 1;
    }

    @Override
    public void step(ArrayList<Unit> units) {
        Unit tmp = nearestEnemy(units);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }

    public String getInfo(){
        return String.format("%s  🎒: %d", super.getInfo(),
                this.capacity);
    }
}

