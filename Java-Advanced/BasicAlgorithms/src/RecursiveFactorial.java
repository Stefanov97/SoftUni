import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int factorial = getFactorial(number);
        System.out.println(factorial);
    }

    private static int getFactorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        }
        return number * getFactorial(number - 1);
    }
}
