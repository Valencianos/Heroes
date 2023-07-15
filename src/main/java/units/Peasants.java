package units;

import java.util.ArrayList;


public class Peasants extends Unit implements IntGame{

    public int capacity;

    public Peasants(int x, int y) {
        super(getName(), 10, 20, 80, new int[]{5, 10}, 8, 8, x, y);
        this.capacity = 1;
    }

    @Override
    public void step(ArrayList<Unit>myTeam, ArrayList<Unit>oppTeam) {
        if(status.equals("die")){
            status = "stand";
        }
    }


    public String getInfo(){
        return String.format("%s  🎒: %d", super.getInfo(),
                this.capacity);
    }


}

