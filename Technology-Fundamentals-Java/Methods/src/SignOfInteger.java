import java.util.Scanner;

public class SignOfInteger {
    static void printSign(int number) {
        String type;
        if (number > 0) {
            type = "positive";
        } else if (number < 0) {
            type = "negative";
        } else {
            type = "zero";
        }
        System.out.printf("The number %d is %s.", number, type);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printSign(number);
    }
}
