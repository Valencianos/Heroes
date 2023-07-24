package units;


public class Thieves extends Infantries{

    public Thieves(int x, int y){
        super(getName(), 120, 600, 120, 80, 6,
                1, x, y, true);
    }
    @Override
    public String getInfo(){
        return "Thief " + "[" + coordinates.x + ", " + coordinates.y + "] ❤️ " + health + "/" + maxHealth + " " + status;
    }
}
