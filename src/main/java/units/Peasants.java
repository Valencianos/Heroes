package units;

import java.util.ArrayList;


public class Peasants extends Unit implements IntGame{

    public int capacity;

    public Peasants(int x, int y) {
        super(getName(), 10, 20, 80, 8, 8, x, y, true);
        this.capacity = 1;
    }

    @Override
    public void step(ArrayList<Unit>oppTeam, ArrayList<Unit>myTeam) {
        if(isAlive){
            if(status.equals("busy")) {
                status = "stand";
            }
        }
    }

    @Override
    public String getInfo(){
        return "Peasant " + "[" + coordinates.x + ", " + coordinates.y + "] ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
