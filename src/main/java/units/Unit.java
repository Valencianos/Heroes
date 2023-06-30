package units;

import java.util.Random;

public abstract class Unit {
    public String name;
    public int health;
    public int defence;
    public int attack;
    public int speed;
    public int actionPoints;
    protected static int num;
    protected static Random ran;
    static{
        Unit.num = 0;
        Unit.ran = new Random();
    }

    public Unit(String name, int health, int attack, int defence, int speed, int actionPoints) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.actionPoints = actionPoints;
    }

//    public Unit(){
//        this(String.format("Hero_Archers #%d", ++Unit.num), Unit.ran.nextInt(50,100));
//    }

    public String getInfo(){
        return String.format("Name: %s Type: %s Hp: %d Att: %d Def: %d Sp: %d Ap: %d",
                this.name, this.getClass().getSimpleName(), this.health, this.attack, this.defence, this.speed, this.actionPoints);
    }

    public void healed(int Hp) {
        this.health = Hp + this.health;
    }

    public void GetDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        }
        // else { die(); }
    }

    public void attack(Unit target){
        int damage = Unit.ran.nextInt(0,100);
        target.GetDamage(damage);
    }

    public static String getName(){
        String s = String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
        return s;
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
