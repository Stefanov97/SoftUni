import java.util.Scanner;

public class DemoTheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int playersCount = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayForPerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayForPerson = Double.parseDouble(scanner.nextLine());
        double totalWater = days * playersCount * waterPerDayForPerson;
        double totalFood = days * playersCount * foodPerDayForPerson;
        int dayCounter = 0;
        for (int i = 0; i < days; i++) {
            dayCounter++;
            double lostEnergy = Double.parseDouble(scanner.nextLine());
            groupEnergy -= lostEnergy;
            if (groupEnergy <= 0) {
                break;
            }
            if (dayCounter % 2 == 0) {
                groupEnergy *= 1.05;
                totalWater *= 0.7;
            }
            if (dayCounter % 3 == 0) {
                groupEnergy *= 1.10;
                totalFood -= totalFood / playersCount;
            }

        }
        if (groupEnergy > 0) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
        }
    }
}
