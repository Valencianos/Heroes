package units;

public class Coordinates {
    int x, y;

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Boolean isEquals(Coordinates opponent){
        return opponent.y == y && opponent.x == x;
    }

    public float getDistance(Coordinates coordinates){
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
}
