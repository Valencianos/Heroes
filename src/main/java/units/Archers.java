package units;

public abstract class Archers extends Unit{

    public int accuracy;
    public int arrows;

    public Archers(String name, int attack, int defence, int health, int[] damage,
                   int speed, int actionPoints, int accuracy, int arrows, int x, int y) {
        super(name, attack, defence, health, damage, speed, actionPoints, x, y);
        this.accuracy = accuracy;
        this. arrows = arrows;
    }

    public String getInfo(){
        return String.format("%s  🎯: %d 🏹: %d", super.getInfo(),
                this.accuracy, this.arrows);
    }
}
