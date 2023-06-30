package units;

public class Wizards extends Unit{

    public Wizards() {
        super(getName(),
                Wizards.ran.nextInt(100, 150),
                Wizards.ran.nextInt(25, 50),
                Wizards.ran.nextInt(50, 75),
                Wizards.ran.nextInt(10, 20),
                Wizards.ran.nextInt(13, 18));
    }

}
