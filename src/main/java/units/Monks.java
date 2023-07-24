package units;


public class Monks extends Wizards{

    public Monks(int x, int y) {

        super(getName(), 60, 400, 60, 35, 2, 10,
                50, 100, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Monk " + "[" + coordinates.x + ", " + coordinates.y + "] 💟" + mana + " ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
