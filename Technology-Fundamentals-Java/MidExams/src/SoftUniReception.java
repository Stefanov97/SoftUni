import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEfficity = Integer.parseInt(scanner.nextLine());
        int secondEfficity = Integer.parseInt(scanner.nextLine());
        int thirdEfficity = Integer.parseInt(scanner.nextLine());

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int original = studentsCount;

        int totalEfficity = firstEfficity + secondEfficity + thirdEfficity;
        int hourCounter = 1;
        while (studentsCount > 0) {
            if (hourCounter % 4 == 0) {
                hourCounter++;
                continue;
            }
            studentsCount -= totalEfficity;
            if (studentsCount <= 0) {
                break;
            }
            hourCounter++;
        }
        if (original == 0) {
            System.out.printf("Time needed: %dh.", original);
        } else {
            System.out.printf("Time needed: %dh.", hourCounter);
        }
    }
}
