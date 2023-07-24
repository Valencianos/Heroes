package units;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class launch {

    public static ArrayList<Unit> firstTeam = new ArrayList<>();
    public static ArrayList<Unit> secondTeam = new ArrayList<>();
    public static ArrayList<Unit> allTeam = new ArrayList<>();
    public static void main(String[] args) {

        int teamCount = 10;
        boolean sortedSpeed = false;
        Random rand = new Random();
        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> firstTeam.add(new Spearmans(1, i +1));
                case 1 -> firstTeam.add(new Magicians(1, i +1));
                case 2 -> firstTeam.add(new Crossbowmans(1, i +1));
                case 3 -> firstTeam.add(new Peasants(1, i +1));
            }
        }

        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(4);
            switch (val) {
                case 0 -> secondTeam.add(new Thieves(10, i +1));
                case 1 -> secondTeam.add(new Monks(10, i +1));
                case 2 -> secondTeam.add(new Snipers(10, i +1));
                case 3 -> secondTeam.add(new Peasants(10, i +1));
            }
        }
        allTeam.addAll(firstTeam);
        allTeam.addAll(secondTeam);

        while(!sortedSpeed){
            sortedSpeed = true;
            for(int i = 0; i < firstTeam.size() - 1; i++){
                if(firstTeam.get(i).speed < firstTeam.get(i+1).speed){
                    Collections.swap(firstTeam, i, i+ 1);
                    sortedSpeed = false;
                }
            }
        }
        sortedSpeed = false;
        while(!sortedSpeed){
            sortedSpeed = true;
            for(int i = 0; i < secondTeam.size() - 1; i++){
                if(secondTeam.get(i).speed < secondTeam.get(i+1).speed){
                    Collections.swap(secondTeam, i, i+ 1);
                    sortedSpeed = false;
                }
            }
        }

        View.view();
        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            int sp1 = 0;
            int sp2 = 0;
            Unit tempFirstTeam = firstTeam.get(sp1);
            Unit tempSecondTeam = secondTeam.get(sp2);
            for (int i = 0; i < 20; i++) {
                if ((tempFirstTeam.speed >= tempSecondTeam.speed && sp1 < 10) || (tempFirstTeam.speed < tempSecondTeam.speed && sp2 == 10)) {
                    tempFirstTeam.step(secondTeam, firstTeam);
                    sp1++;
                    if(sp1 < 10) tempFirstTeam = firstTeam.get(sp1);
                } else {
                    tempSecondTeam.step(firstTeam, secondTeam);
                    sp2++;
                    if(sp2 < 10) tempSecondTeam = secondTeam.get(sp2);
                }
                if (isTeamAlive(firstTeam)) {
                    System.out.println("Second Team (Blue) wins");
                    break;
                }
                if (isTeamAlive(secondTeam)) {
                    System.out.println("First Team (Green) wins");
                    break;
                }
            }
            View.view();
        }
    }

    public static boolean isTeamAlive(ArrayList<Unit> team){
        for (Unit unit: team){
            if(!unit.status.equals("die")) return false;
        }
        return true;
    }

}



