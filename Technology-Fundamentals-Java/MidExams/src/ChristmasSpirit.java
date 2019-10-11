import java.util.Scanner;

public class ChristmasSpirit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allowedQuantity = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int ournamentSetPrice = 2;
        int treeSkirtPrice = 5;
        int treeGarlandsPrice = 3;
        int treeLightsPrice = 15;

        int christmasSpirit = 0;
        int totalPrice = 0;

        for (int i = 1; i <= days; i++) {
            if (i % 11 == 0) {
                allowedQuantity += 2;
            }
            if (i % 2 == 0) {
                christmasSpirit += 5;
                totalPrice += ournamentSetPrice * allowedQuantity;
            }
            if (i % 3 == 0) {
                totalPrice += treeSkirtPrice * allowedQuantity;
                totalPrice += treeGarlandsPrice * allowedQuantity;
                christmasSpirit += 13;
            }
            if (i % 5 == 0) {
                totalPrice += treeLightsPrice * allowedQuantity;
                christmasSpirit += 17;
            }
            if (i % 15 == 0) {
                christmasSpirit += 30;
            }
            if (i == days && i % 10 == 0) {
                christmasSpirit -= 30;
            }
            if (i % 10 == 0) {
                christmasSpirit -= 20;
                totalPrice += treeSkirtPrice + treeGarlandsPrice + treeLightsPrice;
            }
        }
        System.out.printf("Total cost: %d", totalPrice).println();
        System.out.printf("Total spirit: %d", christmasSpirit);
    }
}
