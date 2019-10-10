import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String dayOfTheWeek = scanner.nextLine();
        double price = 0;

        if (numberOfPeople >= 100 && "Business".equals(typeOfGroup)) {
            numberOfPeople -= 10;
        }

        switch (typeOfGroup) {
            case "Students":
                if (dayOfTheWeek.equals("Friday")) {
                    price = 8.45 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    price = 9.80 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    price = 10.46 * numberOfPeople;
                }
                break;
            case "Business":
                if (dayOfTheWeek.equals("Friday")) {
                    price = 10.90 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    price = 15.60 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    price = 16 * numberOfPeople;
                }
                break;
            case "Regular":
                if (dayOfTheWeek.equals("Friday")) {
                    price = 15 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Saturday")) {
                    price = 20 * numberOfPeople;
                } else if (dayOfTheWeek.equals("Sunday")) {
                    price = 22.50 * numberOfPeople;
                }
                break;
        }
        if (typeOfGroup.equals("Students") && numberOfPeople >= 30) {
            price *= 0.85;
        }
        if (typeOfGroup.equals("Regular") && numberOfPeople >= 10 && numberOfPeople <= 20) {
            price *= 0.95;
        }
        System.out.printf("Total price: %.2f", price);
    }
}
