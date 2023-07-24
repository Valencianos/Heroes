package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Wizards extends Unit{
    public int heal, mana, attackDistance;

    public Wizards(String name, int attack, int health, int damage, int speed, int actionPoints, int attackDistance, int heal, int mana, int x, int y, boolean isAlive) {
        super(name, attack, health, damage, speed, actionPoints, x, y, isAlive);
        this.attackDistance = attackDistance;
        this.heal = heal;
        this.mana = mana;
    }

    public String getInfo(){
        return String.format("%s 🔋: %d 💟: %d", super.toString(),
                this.heal, this.mana);
    }

    @Override
    public void step(ArrayList<Unit>oppTeam, ArrayList<Unit>myTeam) {
        Unit curEnemy = nearestEnemy(oppTeam);
        Unit teammate = myTeam.get(0);
        float minTeammateHealth = 1;
        ArrayList<Unit> fallenUnits = new ArrayList<>();

        if (isAlive) {
            for(Unit unit: myTeam){
                if(((float) unit.health / unit.maxHealth < minTeammateHealth) && unit.isAlive){
                    minTeammateHealth = (float) unit.health / unit.maxHealth;
                    teammate = unit;
                }
                if(!unit.isAlive){
                    fallenUnits.add(unit);
                }
            }
            if (fallenUnits.size() > myTeam.size() / 2 && mana > 99){
                int ran = new Random().nextInt(fallenUnits.size() - 1);
                fallenUnits.get(ran).isAlive = true;
                fallenUnits.get(ran).health = fallenUnits.get(ran).maxHealth / 2;
                mana -= 100;
                teammate.status = "resurrected";
                status = "resurrection";
                return;
            }
            if(minTeammateHealth < 1 && mana > 49){
                teammate.getDamage(-damage);
                mana -= 50;
                status = "healing";
                return;
            }
            if (coordinates.getDistance(curEnemy.coordinates) <= attackDistance) {
                if (mana > 30) {
                    getAttack(curEnemy, damage);
                    mana -= 30;
                    status = "attack";
                }else{
                    mana += 50;
                    status = "busy";
                }
            } else {
                move(curEnemy.coordinates, myTeam);
                status = "moving";
            }
        }
    }
}

