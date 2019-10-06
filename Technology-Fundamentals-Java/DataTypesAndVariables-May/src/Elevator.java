import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine()); //17
        int capacity = Integer.parseInt(scanner.nextLine()); //3

        int count = 0;

        while (people > 0) {
            count++;
            people -= capacity;
        }
        System.out.println(count);

    }
}
