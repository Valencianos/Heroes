package units;


public class Magicians extends Wizards {

    public Magicians(int x, int y) {
        super(getName(), 70, 30, 150, 30, 2, 10, 50, 50, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Magician " + "[" + coordinates.x + ", " + coordinates.y + "] 💟" + mana + " ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
