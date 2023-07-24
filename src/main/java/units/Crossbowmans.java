package units;

public class Crossbowmans extends Archers implements IntGame{

    public Crossbowmans(int x, int y) {
        super(getName(), 120, 300, 100, 30, 5, 80,
                5, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Crossbowman " + "[" + coordinates.x + ", " + coordinates.y + "] 🏹" + arrows + " ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
