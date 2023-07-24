package units;


public class Spearmans extends Infantries{

    public Spearmans(int x, int y) {
        super(getName(), 80, 50, 250, 6, 2,
                1, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Spearman " + "[" + coordinates.x + ", " + coordinates.y + "] ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
