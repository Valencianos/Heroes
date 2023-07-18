package units;


import java.util.ArrayList;

public class Coordinates {
    int x, y;
    ArrayList<Integer> xy = new ArrayList<>();

    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
        xy.add(0, x);
        xy.add(1, y);
    }

    public Coordinates newPosition(Coordinates enemyPosition, ArrayList<Unit> team){
        Coordinates currentPosition = new Coordinates(x, y);
        if(Math.abs(enemyPosition.x - x) >= Math.abs(enemyPosition.y - y)){
            if(enemyPosition.x - x > 0) currentPosition.x += 1;
            else currentPosition.x -= 1;
        }
        if(Math.abs(enemyPosition.x - x) < Math.abs(enemyPosition.y - y)){
            if(enemyPosition.y - y > 0) currentPosition.y += 1;
            else currentPosition.y -= 1;
        }
        return currentPosition;
    }

    public float getDistance(Coordinates coordinates){
        int dx = coordinates.x - x;
        int dy = coordinates.y - y;
        return Math.round(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    public boolean containsByPosition(Coordinates nextPosition, ArrayList<Unit> team){
        for(Unit unit: team){
            if(unit.coordinates == nextPosition) return true;
        }
        return false;
    }
}
