import java.util.Scanner;

public class TopNumber {
    static void printTopNumbers(int number) {
        for (int i = 1; i <= number; i++) {

            boolean hasOddDigit = false;
            String numToString = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < numToString.length(); j++) {

                int digit = Integer.parseInt(String.valueOf(numToString.charAt(j)));
                sum += digit;
                if (digit % 2 != 0) {
                    hasOddDigit = true;

                }
            }
            if (sum % 8 == 0) {
                if (hasOddDigit) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printTopNumbers(number);

    }
}
