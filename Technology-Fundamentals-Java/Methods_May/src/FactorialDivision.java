import java.util.Scanner;

public class FactorialDivision {
    static long getFactorial(int number) {
        long numberFactorial = 1;
        for (int i = 1; i <= number; i++) {
            numberFactorial *= i;
        }
        return numberFactorial;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        double firstFactorial = getFactorial(first);
        double secondFactorial = getFactorial(second);

        System.out.printf("%.2f", firstFactorial / secondFactorial);


    }
}
