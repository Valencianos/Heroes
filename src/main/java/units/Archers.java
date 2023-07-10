package units;

import java.util.ArrayList;

public abstract class Archers extends Unit{

    public int accuracy;
    public int arrows;

    public Archers(String name, int attack, int defence, int health, int[] damage,
                   int speed, int actionPoints, int accuracy, int arrows, int x, int y) {
        super(name, attack, defence, health, damage, speed, actionPoints, x, y);
        this.accuracy = accuracy;
        this.arrows = arrows;
    }

    public String getInfo(){
        return String.format("%s  🎯: %d 🏹: %d", super.getInfo(),
                this.accuracy, this.arrows);
    }


    @Override
    public void step(ArrayList<Unit>myTeam, ArrayList<Unit>oppTeam) {
        if(getHealth() < 1 || arrows < 1){
            return;
        }
        Unit curEnemy = nearestEnemy(myTeam);
        getAttack(curEnemy, damage);
        for (Unit units:myTeam) {
            if (units.name.equals("Peasant")){
                arrows++;
                break;
            }
        }
        arrows--;
    }
}
