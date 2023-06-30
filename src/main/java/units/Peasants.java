package units;

public class Peasants extends Unit{

    public int capacityOfShells;

    public Peasants() {
        super(getName(),
                Peasants.ran.nextInt(0, 50),
                Peasants.ran.nextInt(0, 25),
                Peasants.ran.nextInt(0, 25),
                Peasants.ran.nextInt(15, 25),
                Peasants.ran.nextInt(15, 20));
        this.capacityOfShells = Peasants.ran.nextInt(5, 10);
    }
    public String getInfo(){
        return String.format("%s  CoS: %d", super.getInfo(),
                this.capacityOfShells);
    }
}

