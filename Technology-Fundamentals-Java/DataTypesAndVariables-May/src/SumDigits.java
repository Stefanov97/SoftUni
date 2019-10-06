import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int numToInt = Integer.parseInt(number);
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int numToSum = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += numToSum;
        }
        System.out.println(sum);
    }
}
