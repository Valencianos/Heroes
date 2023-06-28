package units;

public class Infantries extends unit{
    public int armour;
    public int stamina;
    public Infantries(String name, int health, int defence, int actionPoints, int attack, int speed) {
        super(name, health, defence, actionPoints, attack, speed);
    }
}
