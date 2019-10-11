import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#+");
        int water = Integer.parseInt(scanner.nextLine());
        String almost = "";
        for (int i = 0; i < input.length; i++) {
            almost += input[i] + " ";
        }

        List<String> finished = Arrays.stream(almost.split(" +")).collect(Collectors.toList());
        for (int i = 0; i < finished.size(); i++) {
            if (finished.get(i).equals("=")) {
                finished.remove(i);
            }
        }
        double effort = 0;
        List<Integer> cells = new ArrayList<>();
        for (int i = 0; i < finished.size(); i += 2) {
            int levelFire = Integer.parseInt(finished.get(i + 1));
            switch (finished.get(i)) {
                case "High":
                    if (levelFire >= 81 && levelFire <= 125) {
                        if (water >= levelFire) {
                            water -= levelFire;
                            effort += levelFire * 0.25;
                            cells.add(levelFire);
                        } else {
                            continue;
                        }
                    }
                    break;
                case "Medium":
                    if (levelFire >= 51 && levelFire <= 80) {
                        if (water >= levelFire) {
                            water -= levelFire;
                            effort += levelFire * 0.25;
                            cells.add(levelFire);
                        } else {
                            continue;
                        }
                    }
                    break;
                case "Low":
                    if (levelFire >= 1 && levelFire <= 50) {
                        if (water >= levelFire) {
                            water -= levelFire;
                            effort += levelFire * 0.25;
                            cells.add(levelFire);
                        } else {
                            continue;
                        }
                    }
                    break;
            }
        }
        System.out.println("Cells:");
        int totalFire = 0;
        for (Integer cell : cells) {
            System.out.println("- " + cell);
            totalFire += cell;
        }
        System.out.printf("Effort: %.2f", effort).println();
        System.out.printf("Total Fire: %d", totalFire);
    }
}
