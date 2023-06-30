package units;

import java.util.Random;

public class Infantries extends Unit{

    public int armour;
    public int stamina;

    public Infantries() {
        super(getName(),
                Infantries.ran.nextInt(150, 200),
                Infantries.ran.nextInt(50, 75),
                Infantries.ran.nextInt(75, 100),
                Infantries.ran.nextInt(5, 15),
                Infantries.ran.nextInt(12, 17));
        this.armour = Infantries.ran.nextInt(30, 40);
        this.stamina = Infantries.ran.nextInt(40, 50);
    }
    public String getInfo(){
        return String.format("%s  Arm: %d Stm: %d", super.getInfo(),
                this.armour, this.stamina);
    }
}

