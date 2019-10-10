import java.util.Scanner;

public class MultiplyEvensByOdds {
    static int printSum(String number) {
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < number.length(); i++) {
            boolean isValid = true;
            while (String.valueOf(number.charAt(i)).equals("-")) {
                isValid = false;
                break;
            }
            if (!isValid) {
                continue;
            }
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (digit % 2 == 0) {
                evenSum += digit;
            } else {
                oddSum += digit;
            }
        }
        return oddSum * evenSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        System.out.println(printSum(number));
    }
}
