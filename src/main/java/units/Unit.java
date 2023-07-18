package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Unit implements IntGame{
    protected String name;
    protected int attack, health, maxHealth, speed, actionPoints;
    protected int[] damage;
    protected boolean isAlive;
    protected String status;

    protected Coordinates coordinates;

    public Unit(String name, int attack, int health, int[] damage, int speed, int actionPoints, int x, int y) {
        this.name = name;
        this.attack = attack;
        this.maxHealth = health;
        this.health = maxHealth;
        this.damage = damage;
        this.speed = speed;
        this.actionPoints = actionPoints;
        this.status = "stand";
        coordinates = new Coordinates(x, y);
    }

    public String getInfo(){
        return String.format("👤: %s 📜: %s ❤️: %d ⚔️: %d 🏃🏻‍️: %d 🦶🏻: %d 📍: {%d %d}",
                this.name, this.getClass().getSimpleName(), this.health, this.attack, this.speed,
                this.actionPoints, coordinates.x, coordinates.y);
    }

    public int getHealth(){
        return health;
    }

    protected String getStatus() {
        return status;
    }
    protected void setStatus(String status) {
        this.status = status;
    }

    public void getDamage(int damage) {
        health -= damage;
        if (health - damage < 1) {
            status = "die";
            health = 0;
        }
        if(health > maxHealth) health = maxHealth;
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

    public static int compare(Unit o1, Unit o2){
        return Integer.compare(o2.speed,o1.speed);
    }

    public ArrayList<Integer> getPosition(){
        return coordinates.xy;
    }

    public void move(Coordinates enemyPos){
        for(int i = 0; i < moveDist; i++){

        }
    }
}
