import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DungeonestDark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\|+");
        String text = "";
        int coins = 0;
        int health = 100;

        for (int i = 0; i < firstInput.length; i++) {
            text += firstInput[i] + " ";
        }
        List<String> monsters = Arrays.stream(text.split(" +")).collect(Collectors.toList());
        boolean isDead = false;
        int bestRoom = 0;
        for (int i = 0; i < monsters.size(); i += 2) {
            bestRoom++;
            int power = Integer.parseInt(monsters.get(i + 1));
            String command = monsters.get(i);

            switch (command) {
                case "potion":
                    int healedFor = 0;
                    if (power + health > 100) {
                        healedFor = 100 - health;
                        health = 100;
                    } else {
                        health += power;
                        healedFor = power;
                    }
                    System.out.println(String.format("You healed for %d hp.", healedFor));
                    System.out.println(String.format("Current health: %d hp.", health));
                    break;
                case "chest":
                    coins += power;
                    System.out.println(String.format("You found %d coins.", power));
                    break;
                default:
                    health -= power;
                    if (health > 0) {
                        System.out.printf("You slayed %s.", command).println();
                    } else {
                        System.out.printf("You died! Killed by %s.", command).println();
                        System.out.println(String.format("Best room: %d", bestRoom));
                        isDead = true;
                    }
                    break;
            }
            if (isDead) {
                break;
            }
        }
        if (!isDead) {
            System.out.printf("You've made it!").println();
            System.out.printf("Coins: %d", coins).println();
            System.out.printf("Health: %d", health);
        }
    }
}
