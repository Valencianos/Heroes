package units;

import java.util.ArrayList;

public abstract class Archers extends Unit{

    protected int accuracy, arrows, attackDistance;

    public Archers(String name, int attack, int health, int damage, int speed, int attackDistance,
                   int accuracy, int arrows, int x, int y, boolean isAlive) {
        super(name, attack, health, damage, speed, 3, x, y, isAlive);
        this.attackDistance = attackDistance;
        this.accuracy = accuracy;
        this.arrows = arrows;
    }

    public String getInfo(){
        return String.format("%s  🎯: %d 🏹: %d AP: %d", super.toString(),
                this.accuracy, this.arrows, this.actionPoints);
    }


    @Override
    public void step(ArrayList<Unit>oppTeam, ArrayList<Unit>myTeam) {
        Unit curEnemy = nearestEnemy(oppTeam);
        if (!isAlive) return;
        else{
            for (Unit units:myTeam) {
                if (units instanceof Peasants && units.status.equals("stand") && arrows < 5){
                    arrows += 1;
                    units.status = "busy";
                    return;
                }
            }
        }
        if(coordinates.getDistance(curEnemy.coordinates) <= attackDistance){
            if(arrows > 0){
                getAttack(curEnemy, damage);
                arrows -= 1;
                status = "attack";
                return;
            }

        }else{
            move(curEnemy.coordinates, myTeam);
            status = "moving";
            return;
        }
    }
}

