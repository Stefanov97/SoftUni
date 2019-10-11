import java.util.Scanner;

public class DistanceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stepsMade = Integer.parseInt(scanner.nextLine());
        double lengthStep = Double.parseDouble(scanner.nextLine());
        int goal = Integer.parseInt(scanner.nextLine());
        int shortSteps = stepsMade / 5;
        double shortLenght = lengthStep * 0.7;
        int normalSteps = stepsMade - shortSteps;

        double totalTravelled = (normalSteps * lengthStep + shortSteps * shortLenght);
        double goalInCm = goal * 100.0;
        double percentage = (totalTravelled / goalInCm) * 100;

        System.out.printf("You travelled %.2f%% of the distance!", percentage);


    }
}

