package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(tokens[0]);
        int numberOfDays = Integer.parseInt(tokens[1]);
        String seasonName = tokens[2].toUpperCase();
        String discountName = tokens[3].toUpperCase();
        Season season = Season.valueOf(seasonName);
        Discount discount = Discount.SECOND_VISIT;
        if (!discountName.equals("SECONDVISIT")) {
            discount = Discount.valueOf(discountName);
        }
        PriceCalculator calculator = new PriceCalculator(pricePerDay, numberOfDays, season, discount);
        System.out.printf("%.2f", calculator.calculate());
    }
}
