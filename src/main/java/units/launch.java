package units;

import java.util.ArrayList;
import java.util.Random;

public class launch {
    public static void main(String[] args) {

        ArrayList<Unit> firstTeam = createFirstTeam();
        ArrayList<Unit> secondTeam = createSecondTeam();

        System.out.println("_".repeat(70) + "\n" + "First Team:");
        firstTeam.forEach(n -> System.out.println(n.getInfo()));
        System.out.println("_".repeat(70) + "\n" + "Second Team:");
        secondTeam.forEach(n -> System.out.println(n.getInfo()));

        System.out.println("_".repeat(70) + "\n" + "The nearest opponent:");
        firstTeam.forEach(n -> n.step(secondTeam));
    }

    static int teamCount = 10;
    static Random rand = new Random();
    public static ArrayList<Unit> createFirstTeam(){
        ArrayList<Unit> team1 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team1.add(new Thieves(team1, 0, rand.nextInt(0,10)));
                case 1 -> team1.add(new Magicians(team1, 0, rand.nextInt(0,10)));
                case 2 -> team1.add(new Crossbowmans(team1, 0, rand.nextInt(0,10)));
                case 3 -> team1.add(new Peasants(team1, 0, rand.nextInt(0,10)));
            }
        }
        return team1;
    }

    public static ArrayList<Unit> createSecondTeam(){
        ArrayList<Unit> team2 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team2.add(new Spearmans(team2, 9, rand.nextInt(0,10)));
                case 1 -> team2.add(new Monks(team2, 9, rand.nextInt(0,10)));
                case 2 -> team2.add(new Snipers(team2, 9, rand.nextInt(0,10)));
                case 3 -> team2.add(new Peasants(team2, 9, rand.nextInt(0,10)));
            }
        }
        return team2;
    }
}
