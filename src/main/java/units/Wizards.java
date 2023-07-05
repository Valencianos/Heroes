package units;

public abstract class Wizards extends Unit{
    public int heal;

    public Wizards(String name, int attack, int defence, int health, int[] damage, int speed, int actionPoints, int heal, int x, int y) {
        super(name, attack, defence, health, damage, speed, actionPoints, x, y);
        this.heal = heal;
    }

    public String getInfo(){
        return String.format("%s 🔋: %d", super.getInfo(),
                this.heal);
    }
}
