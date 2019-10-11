import java.util.Scanner;

public class CookingMasterClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfFlourPerPackage = Double.parseDouble(scanner.nextLine());
        double priceForOneEgg = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());

        double totalApronPrice = apronPrice * (Math.ceil(students + students * 0.2));
        double totalEggsPrice = students * 10 * priceForOneEgg;
        double totalFlourPrice = priceOfFlourPerPackage * (students - (students / 5));

        double totalPrice = totalApronPrice + totalEggsPrice + totalFlourPrice;

        if (budget >= totalPrice) {
            System.out.printf("Items purchased for %.2f$.", totalPrice);
        } else {
            System.out.printf("%.2f$ more needed.", totalPrice - budget);
        }
    }
}
