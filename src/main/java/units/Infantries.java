package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Infantries extends Unit{

    public int armour;
    public Infantries(String name, int attack, int defence, int health, int[] damage, int speed, int actionPoints, int armour, int x, int y) {
        super(name, attack, defence, health, damage, speed, actionPoints, x, y);
        this.armour = armour;
    }

    public String getInfo(){
        return String.format("%s  🪖: %d", super.getInfo(),
                this.armour);
    }

    @Override
    public void step(ArrayList<Unit>myTeam, ArrayList<Unit>oppTeam) {
        Unit tmp = nearestEnemy(oppTeam);
        System.out.println(tmp.name + " " + coordinates.getDistance(tmp.coordinates));
    }
}

