package units;

public class Archers extends Unit{

    public int accuracy;
    public int numberOfShells;

    public Archers() {
        super(getName(),
                Archers.ran.nextInt(50, 100),
                Archers.ran.nextInt(75, 100),
                Archers.ran.nextInt(25, 50),
                Archers.ran.nextInt(10, 20),
                Archers.ran.nextInt(10, 15));
        this.accuracy = Archers.ran.nextInt(30, 40);
        this.numberOfShells = Archers.ran.nextInt(10, 15);
    }
    public String getInfo(){
        return String.format("%s  Acc: %d NoS: %d", super.getInfo(),
                this.accuracy, this.numberOfShells);
    }
}
