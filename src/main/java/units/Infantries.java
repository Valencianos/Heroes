package units;

import java.util.ArrayList;


public abstract class Infantries extends Unit{

    protected int attackDistance;
    public Infantries(String name, int attack, int health, int damage, int speed, int actionPoints, int attackDistance, int x, int y, boolean isAlive) {
        super(name, attack, health, damage, speed, actionPoints, x, y, isAlive);
        this.attackDistance = attackDistance;
    }

    public String getInfo(){
        return String.format("%s  ", super.toString());
    }

    @Override
    public void step(ArrayList<Unit>oppTeam, ArrayList<Unit>myTeam) {
        Unit curEnemy = nearestEnemy(oppTeam);
        if (isAlive) {
            if (coordinates.getDistance(curEnemy.coordinates) <= attackDistance) {
                getAttack(curEnemy, damage);
                status = "attack";
            } else {
                move(curEnemy.coordinates, myTeam);
                status = "moving";
            }
        }
    }
}

