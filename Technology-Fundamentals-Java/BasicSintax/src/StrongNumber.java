import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();//145


        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            int factorial = 1;
            for (int j = 1; j <= digit; j++) {
                factorial *= j;

            }
            sum += factorial;

        }
        int finalNum = Integer.parseInt(number);
        if (sum == finalNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
