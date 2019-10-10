import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!"Start".equals(input)) {
            double money = Double.parseDouble(input);
            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                totalMoney += money;

            } else {
                System.out.printf("Cannot accept %.2f", money).println();
            }
            input = scanner.nextLine();
        }
        String secondInput = scanner.nextLine();
        boolean isValid = true;
        while (!"End".equals(secondInput)) {
            String product = secondInput;
            double price = 0;
            switch (product) {
                case "Nuts":
                    price = 2;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1;
                    break;
                default:
                    System.out.println("Invalid product");
                    isValid = false;
            }
            if (isValid) {
                if (totalMoney >= price) {
                    System.out.printf("Purchased %s", product).println();
                    totalMoney -= price;
                } else {
                    System.out.println("Sorry, not enough money");
                }
            }

            secondInput = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", totalMoney);
    }
}
