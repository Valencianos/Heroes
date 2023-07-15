package units;


public class Coordinates {
    int x, y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }


    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public float getDistance(Coordinates coordinates){
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
}
