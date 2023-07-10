package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Unit implements IntGame{
    protected String name;
    protected int attack, defence, health, maxHealth, speed, actionPoints;
    protected int[] damage;
    protected static int num;
    protected List<Unit> list;
    private String status;

    public Unit(List<Unit> heroes){
        list = heroes;
    }
    protected static Random ran;
    static{
        Unit.num = 0;
        Unit.ran = new Random();
    }
    protected Coordinates coordinates;

    public Unit(String name, int attack, int defence, int health, int[] damage, int speed, int actionPoints, int x, int y) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = health;
        this.health = maxHealth;
        this.damage = damage;
        this.speed = speed;
        this.actionPoints = actionPoints;
        this.coordinates = new Coordinates(x, y);
    }

    public String getInfo(){
        return String.format("👤: %s 📜: %s ❤️: %d ⚔️: %d 🛡️: %d 🏃🏻‍️: %d 🦶🏻: %d 📍: {%d %d}",
                this.name, this.getClass().getSimpleName(), this.health, this.attack, this.defence, this.speed,
                this.actionPoints, coordinates.x, coordinates.y);
    }

    public int getHealth(){
        return health;
    }
    public void getHeal(int Hp) {
        health = Hp + health;
        if(health > maxHealth){
            health = maxHealth;
        }
    }

    protected String getStatus() {
        return status;
    }
    protected void setStatus(String status) {
        this.status = status;
    }

    public void getDamage(int damage) {
        if (health - damage > 0) {
            health -= damage;
        }
        else { die(); }
    }

    public void die(){
        if(health < 0){
            status = "Die";
        }
    }

    public void getAttack(Unit target, int[] damage){
        int dam = (damage[0] + damage[1]) / 2;
        target.getDamage(dam);
    }

    public static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public Unit nearestEnemy(ArrayList<Unit> enemyTeam){
        Unit nearEnemy = enemyTeam.get(0);
        double nearDist = Double.MAX_VALUE;
        for (int i = 0; i < enemyTeam.size(); i++) {
            if (coordinates.getDistance(enemyTeam.get(i).coordinates) < nearDist) {
                nearEnemy = enemyTeam.get(i);
                nearDist = coordinates.getDistance(enemyTeam.get(i).coordinates);
            }
        }
        return nearEnemy;
    }
}
