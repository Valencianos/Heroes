package units;

import java.util.Collections;

public class View {
    private static int step = 1;
    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%" + dif + "s", ":\t"); else System.out.print(":\t");
    }
    private static String formatDiv(String str) {
        return str.replace('a', '┌')
                .replace('b', '┬')
                .replace('c', '┐')
                .replace('d', '├')
                .replace('e', '┼')
                .replace('f', '┤')
                .replace('g', '└')
                .replace('h', '┴')
                .replace('i', '┘')
                .replace('-', '─');
    }
    private static String getChar(int x, int y){
        String out = "| ";
        for (Unit unit: launch.allTeam) {
            if (unit.getPosition().getX() == x && unit.getPosition().getY() == y){
                if (unit.status.equals("die")) {
                    out = "|" + (Colors.ANSI_RED + unit.toString().charAt(0) + Colors.ANSI_RESET);
                    break;
                }
                if (launch.firstTeam.contains(unit)) out = "|" + (Colors.ANSI_GREEN + unit.toString().charAt(0) + Colors.ANSI_RESET);
                if (launch.secondTeam.contains(unit)) out = "|" + (Colors.ANSI_BLUE + unit.toString().charAt(0) + Colors.ANSI_RESET);
                break;
            }
        }
        return out;
    }
    public static void view() {
        if (step == 1 ){
            System.out.print(Colors.ANSI_YELLOW + "First step" + Colors.ANSI_RESET);
        } else {
            System.out.print(Colors.ANSI_YELLOW+ "Step " + step + Colors.ANSI_RESET);
        }
        step++;
        launch.allTeam.forEach((v) -> l[0] = Math.max(l[0], v.getInfo().length()));
        System.out.print("_".repeat(l[0]*2));
        System.out.println();
        System.out.print(top10 + "    ");
        System.out.print(Colors.ANSI_GREEN+":\tGreen side"+Colors.ANSI_RESET);
        //for (int i = 0; i < l[0]-9; i++)
        System.out.print(" ".repeat(l[0]-9));
        System.out.println(Colors.ANSI_BLUE+"Blue side"+Colors.ANSI_RESET);
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(launch.firstTeam.get(0).getInfo());
        tabSetter(launch.firstTeam.get(0).getInfo().length(), l[0]);
        System.out.println(launch.secondTeam.get(0).getInfo());
        System.out.println(midl10);

        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(launch.firstTeam.get(i-1).getInfo());
            tabSetter(launch.firstTeam.get(i-1).getInfo().length(), l[0]);
            System.out.println(launch.secondTeam.get(i-1).getInfo());
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(launch.firstTeam.get(9).getInfo());
        tabSetter(launch.firstTeam.get(9).getInfo().length(), l[0]);
        System.out.println(launch.secondTeam.get(9).getInfo());
        System.out.println(bottom10);
    }
}
