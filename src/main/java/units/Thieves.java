package units;

import java.util.Random;

public class Thieves extends Infantries{
    public Thieves(String name) {
        super(name, new Random().nextInt(30,40), new Random().nextInt(40,50),
                new Random().nextInt(5,7), new Random().nextInt(60, 65),
                new Random().nextInt(80,90));
    }
}
