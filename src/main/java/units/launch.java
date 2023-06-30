package units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class launch {
    public static void main(String[] args) {

        int teamCount = 10;
        Random rand = new Random();

        System.out.println("Team 1:");
        List<Unit> team1 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team1.add(new Infantries());
                case 1 -> team1.add(new Wizards());
                case 2 -> team1.add(new Archers());
                case 3 -> team1.add(new Peasants());
            }
            System.out.println(team1.get(i).getInfo());
        }

        System.out.println("Team 2:");
        List<Unit> team2 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
        int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team2.add(new Infantries());
                case 1 -> team2.add(new Wizards());
                case 2 -> team2.add(new Archers());
                case 3 -> team2.add(new Peasants());
            }
            System.out.println(team2.get(i).getInfo());

        }
    }
}
