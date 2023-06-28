package units;

public abstract class unit {
    public String name;
    public int health;
    public int defence;
    public int attack;
    public int speed;
    public int actionPoints;

    public unit(String name, int health, int defence, int actionPoints, int attack, int speed) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.actionPoints = actionPoints;
    }

    public boolean hasAp(){
        if(actionPoints > 0){
            return true;
        }else{
            return false;
        }
    }
    public int move(){
        while(hasAp()){
            actionPoints -= 1;
        }
        return move();
    }
}
