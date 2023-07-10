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
        firstTeam.forEach(n -> n.step(firstTeam, secondTeam));
        secondTeam.forEach(n-> n.step(secondTeam, firstTeam));

        System.out.println("Team1 damage: ");
        firstTeam.forEach(n-> System.out.println(n.getInfo()));

        System.out.println("Team2 damage: ");
        secondTeam.forEach(n-> System.out.println(n.getInfo()));
    }

    static int teamCount = 5;
    static Random rand = new Random();
    public static ArrayList<Unit> createFirstTeam(){
        ArrayList<Unit> team1 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team1.add(new Thieves(0, rand.nextInt(0,10)));
                case 1 -> team1.add(new Magicians(0, rand.nextInt(0,10)));
                case 2 -> team1.add(new Crossbowmans(0, rand.nextInt(0,10)));
                case 3 -> team1.add(new Peasants(0, rand.nextInt(0,10)));
            }
        }
        return team1;
    }

    public static ArrayList<Unit> createSecondTeam(){
        ArrayList<Unit> team2 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> team2.add(new Spearmans(9, rand.nextInt(0,10)));
                case 1 -> team2.add(new Monks(9, rand.nextInt(0,10)));
                case 2 -> team2.add(new Snipers(9, rand.nextInt(0,10)));
                case 3 -> team2.add(new Peasants(9, rand.nextInt(0,10)));
            }
        }
        return team2;
    }
}
