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
        if(!status.equals("die"))return;
        

            float min_hp = 1000;
            int index = 0;
            for (int i = 0; i < myTeam.size(); i++ ) {
                if((float) (myTeam.get(i).health /maxHealth) < min_hp){
                    min_hp = (float) (myTeam.get(i).health /maxHealth);
                    index = i;
                }

            myTeam.get(index).getDamage((this.damage[0] - this.damage[1]) / 2);
        }
    }
}

