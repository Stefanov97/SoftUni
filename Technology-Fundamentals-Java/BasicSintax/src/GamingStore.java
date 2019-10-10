import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = Double.parseDouble(scanner.nextLine());

        String input = scanner.nextLine();
        double totalSpent = 0;
        boolean hasMoney = true;

        while (!"Game Time".equals(input)) {
            double price = 0;
            boolean isFound = true;
            String game = input;
            switch (game) {
                case "OutFall 4":
                    price = 39.99;
                    break;
                case "CS: OG":
                    price = 15.99;
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    break;
                case "Honored 2":
                    price = 59.99;
                    break;
                case "RoverWatch":
                    price = 29.99;
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    break;
                default:
                    System.out.println("Not Found");
                    isFound = false;
            }
            if (isFound && price <= totalMoney) {
                totalMoney -= price;
                System.out.printf("Bought %s", game).println();
                totalSpent += price;
            } else if (isFound && price > totalMoney) {
                System.out.println("Too Expensive");
            }
            if (totalMoney <= 0) {
                System.out.println("Out of money!");
                hasMoney = false;
                break;
            }

            input = scanner.nextLine();
        }
        if (hasMoney) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, totalMoney);
        }
    }
}
