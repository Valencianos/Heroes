package units;

import java.util.ArrayList;
import java.util.Random;

public abstract class Unit implements IntGame{
    protected String name;
    protected int attack, health, maxHealth, speed, actionPoints, damage;
    protected boolean isAlive;
    protected String status;
    protected Coordinates coordinates;

    public Unit(String name, int attack, int health, int damage, int speed, int actionPoints, int x, int y, boolean isAlive) {
        this.name = name;
        this.attack = attack;
        this.maxHealth = health;
        this.health = maxHealth;
        this.damage = damage;
        this.speed = speed;
        this.actionPoints = actionPoints;
        this.isAlive = isAlive;
        this.status = "stand";
        coordinates = new Coordinates(x, y);
    }

    public String toString(){
        return this.getInfo().split(" ")[0];
    }

    public void getDamage(int damage) {
        health -= damage;
        if (health < 1) {
            status = "die";
            health = 0;
            isAlive = false;
        }
        if(health > maxHealth) health = maxHealth;
    }


    public void getAttack(Unit target, int damage){
        target.getDamage(damage);
    }

    public static String getName(){
        return String.valueOf(Name.values()[new Random().nextInt(Name.values().length)]);
    }

    public Unit nearestEnemy(ArrayList<Unit> enemyTeam){
        Unit nearEnemy = enemyTeam.get(0);
        double nearDist = Double.MAX_VALUE;
        for (Unit unit : enemyTeam) {
            if (coordinates.getDistance(unit.coordinates) < nearDist && unit.isAlive) {
                nearEnemy = unit;
                nearDist = coordinates.getDistance(unit.coordinates);
            }
        }
        return nearEnemy;
    }


    public ArrayList<Integer> getPosition(){
        return coordinates.xy;
    }

    public void move(Coordinates enemyPosition, ArrayList<Unit> team){
        if (!coordinates.containsByPosition(coordinates.newPosition(enemyPosition, team), team)) {
            for (int i = 0; i < actionPoints; i++) {
                coordinates = coordinates.newPosition(enemyPosition, team);
            }
        }
    }
}

