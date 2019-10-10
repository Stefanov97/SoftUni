import java.util.Scanner;

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flourPriceKg = Double.parseDouble(scanner.nextLine());
        double eggsPrice = flourPriceKg * 0.75;
        double milkPrice = (flourPriceKg * 1.25) / 4;
        double totalPrice = flourPriceKg + milkPrice + eggsPrice;

        int counterCozonacs = 0;
        int coloredEggs = 0;

        while (budget >= totalPrice) {
            budget -= totalPrice;
            counterCozonacs++;
            coloredEggs += 3;


            if (counterCozonacs % 3 == 0) {
                coloredEggs -= (counterCozonacs - 2);
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", counterCozonacs, coloredEggs, budget);
    }
}
