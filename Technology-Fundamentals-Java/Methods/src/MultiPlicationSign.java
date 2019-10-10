import java.util.Scanner;

public class MultiPlicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        findWhatTypeIsTheResult(num1, num2, num3);
    }

    static void findWhatTypeIsTheResult(int num1, int num2, int num3) {
        if (num1 == 0 || num2 == 0 || num3 == 0) {
            System.out.println("zero");
        } else if (num1 > 0 && num2 > 0 && num3 > 0) {
            System.out.println("positive");
        } else if (num1 < 0 && num2 < 0 && num3 > 0) {
            System.out.println("positive");
        } else if (num1 > 0 && num2 < 0 && num3 < 0) {
            System.out.println("positive");
        } else if (num1 < 0 && num2 > 0 && num3 < 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
}
