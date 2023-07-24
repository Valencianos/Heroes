package units;


public class Snipers extends Archers implements IntGame {

    public Snipers(int x, int y) {
        super(getName(), 100, 250, 100, 35, 5, 60,
                6, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Sniper " + "[" + coordinates.x + ", " + coordinates.y + "] 🏹" + arrows + " ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
