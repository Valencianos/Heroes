package units;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class launch {

    public static ArrayList<Unit> firstTeam = new ArrayList<>();
    public static ArrayList<Unit> secondTeam = new ArrayList<>();
    public static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {

        int teamCount = 10;
        Random rand = new Random();
        for (int i = 0; i < teamCount; i++) {
             int val = rand.nextInt(4);
             switch (val) {
                 case 0 -> firstTeam.add(new Spearmans(1, rand.nextInt(0, 10)));
                 case 1 -> firstTeam.add(new Magicians(1, rand.nextInt(0, 10)));
                 case 2 -> firstTeam.add(new Crossbowmans(1, rand.nextInt(0, 10)));
                 case 3 -> firstTeam.add(new Peasants(1, rand.nextInt(0, 10)));
                }
            }

        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> secondTeam.add(new Thieves(10, rand.nextInt(0, 10)));
                case 1 -> secondTeam.add(new Monks(10, rand.nextInt(0, 10)));
                case 2 -> secondTeam.add(new Snipers(10, rand.nextInt(0, 10)));
                case 3 -> secondTeam.add(new Peasants(10, rand.nextInt(0, 10)));
                }
            }
        allTeam.addAll(firstTeam);
        allTeam.addAll(secondTeam);
        allTeam.sort(Unit::compare);

//        System.out.println("_".repeat(70) + "\n" + "First Team:");
//        firstTeam.forEach(n -> System.out.println(n.getInfo()));
//        System.out.println("_".repeat(70) + "\n" + "Second Team:");
//        secondTeam.forEach(n -> System.out.println(n.getInfo()));
//
//        System.out.println("_".repeat(70) + "\n" + "The nearest opponent:");
//        firstTeam.forEach(n -> n.step(firstTeam, secondTeam));
//        secondTeam.forEach(n-> n.step(secondTeam, firstTeam));
//
//        System.out.println("Team1 damage: ");
//        firstTeam.forEach(n-> System.out.println(n.getInfo()));
//
//        System.out.println("Team2 damage: ");
//        secondTeam.forEach(n-> System.out.println(n.getInfo()));

        Scanner in = new Scanner(System.in);
        while (true) {
            View.view();
            in.nextLine();
            for (Unit unit : allTeam) {
                if (secondTeam.contains(unit)) {
                    unit.step(firstTeam, secondTeam);
                } else unit.step(secondTeam, firstTeam);
            }
            if (isAlive(firstTeam)) {
                System.out.println("Second Team (Blue) wins");
                break;
            }
            if (isAlive(secondTeam)) {
                System.out.println("First Team (Green) wins");
                break;
            }
        }
    }

    public static boolean isAlive(ArrayList<Unit> team){
        for (Unit unit: team){
            if(unit.status.equals("die")) return true;
        }return false;
    }




}


