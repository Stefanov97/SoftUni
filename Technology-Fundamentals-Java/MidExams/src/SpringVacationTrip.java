import java.util.Scanner;

public class SpringVacationTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfTheTrip = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        int peopleCount = Integer.parseInt(scanner.nextLine());
        double priceFuelPerKm = Double.parseDouble(scanner.nextLine());
        double foodExpensesPerPerson = Double.parseDouble(scanner.nextLine());
        double roomPricePerPersonForOneNight = Double.parseDouble(scanner.nextLine());

        double totalFoodExpenses = daysOfTheTrip * peopleCount * foodExpensesPerPerson;
        double totalPriceForHotel = daysOfTheTrip * peopleCount * roomPricePerPersonForOneNight;
        if (peopleCount > 10) {
            totalPriceForHotel = totalPriceForHotel - (totalPriceForHotel * 0.25);
        }
        double currentExpenses = totalFoodExpenses + totalPriceForHotel;
        boolean isEnoughMoney = true;
        for (int i = 1; i <= daysOfTheTrip; i++) {
            double travelledKilometers = Double.parseDouble(scanner.nextLine());
            double consumedFuel = travelledKilometers * priceFuelPerKm;
            currentExpenses += consumedFuel;
            if (i % 3 == 0 || i % 5 == 0) {
                double additionalExpenses = 0.4 * currentExpenses;
                currentExpenses += additionalExpenses;
            }
            if (i % 7 == 0) {
                double receivedMoney = currentExpenses / peopleCount;
                currentExpenses -= receivedMoney;
            }
            if (currentExpenses > budget) {
                isEnoughMoney = false;
                break;
            }
        }
        if (isEnoughMoney) {
            System.out.printf("You have reached the destination. You have %.2f$ budget left.", budget - currentExpenses);
        } else {
            System.out.printf("Not enough money to continue the trip. You need %.2f$ more.", currentExpenses - budget);
        }
    }
}
