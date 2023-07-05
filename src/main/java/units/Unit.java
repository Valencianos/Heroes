package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Unit implements IntGame{
    protected String name;
    protected int attack, defence, health, maxHealth, speed, actionPoints;
    protected int[] damage;
    protected static int num;
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
    protected List<Unit> list;

    public Unit(List<Unit> heroes){
        list = heroes;
    }

    public String getInfo(){
        return String.format("👤: %s 📜: %s ❤️: %d ⚔️: %d 🛡️: %d 🏃🏻‍️: %d 🦶🏻: %d 📍: {%d %d}",
                this.name, this.getClass().getSimpleName(), this.health, this.attack, this.defence, this.speed,
                this.actionPoints, coordinates.x, coordinates.y);
    }

    public void getHeal(int Hp) {
        this.health = Hp + this.health;
    }

    public void getDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        }
        // else { die(); }
    }

    public void attack(Unit target){
        int damage = Unit.ran.nextInt(0,100);
        target.getDamage(damage);
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
