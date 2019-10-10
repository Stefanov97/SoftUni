import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    static double result(double a, char operator, double b) {
        switch (operator) {
            case '/':
                return a / b;

            case '*':
                return a * b;

            case '+':
                return a + b;

            default:
                return a - b;

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double b = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.##").format(result(a, operator, b)));


    }
}
