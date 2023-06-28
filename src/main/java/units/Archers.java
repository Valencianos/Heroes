package units;

public class Archers extends unit{
    public int accuracy;
    public int numberOfShells;
    public Archers(String name, int health, int defence, int actionPoints, int attack, int speed) {
        super(name, health, defence, actionPoints, attack, speed);
    }
}
