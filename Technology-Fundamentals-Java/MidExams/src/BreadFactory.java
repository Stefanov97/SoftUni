import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BreadFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        String[] separetedCommands = inputLine.split("\\|+");
        String text = "";
        for (int i = 0; i < separetedCommands.length; i++) {
            text += separetedCommands[i] + "-";
        }
        List<String> commands = Arrays.stream(text.split("-+")).collect(Collectors.toList());
        System.out.println();

        int coins = 100;
        int energy = 100;
        boolean hasBankrupted = false;
        for (int i = 0; i < commands.size(); i += 2) {
            int value = Integer.parseInt(commands.get(i + 1));
            String command = commands.get(i);

            boolean banckrupted = false;

            switch (command) {
                case "rest":
                    int firstEnergy = energy;
                    int gainedEnergy = 0;
                    if (energy + value > 100) {
                        energy = 100;
                        gainedEnergy = energy - firstEnergy;
                    } else {
                        gainedEnergy = value;
                        energy += value;
                    }
                    System.out.println("You gained " + gainedEnergy + " energy.");
                    System.out.println("Current energy: " + energy + ".");
                    break;
                case "order":
                    int lastEnergy = energy;
                    energy -= 30;
                    if (energy >= 0) {
                        coins += value;
                        System.out.printf("You earned %d coins.", value).println();
                    } else {
                        lastEnergy += 50;
                        energy = lastEnergy;
                        System.out.println("You had to rest!");
                    }
                    break;
                default:
                    coins -= value; //50 -> 60
                    if (coins > 0) {
                        System.out.printf("You bought %s.", command).println();
                    } else {
                        System.out.printf("Closed! Cannot afford %s.", command);
                        banckrupted = true;
                    }
                    break;
            }

            if (banckrupted) {
                hasBankrupted = true;
                break;
            }
        }
        if (!hasBankrupted) {
            System.out.println("Day completed!");
            System.out.printf("Coins: %d", coins).println();
            System.out.printf("Energy: %d", energy);
        }
    }
}
