import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int originalnum = number;//15


        for (int i = 1; i <= originalnum; i++) {
            int sum = 0;
            int current = i;
            while (current > 0) {
                int lastDigit = current % 10;
                sum += lastDigit;
                current /= 10;
            }
            if (sum == 5 || sum == 7 || sum == 11) {
                System.out.println(i + " " + "-> True");
            } else {
                System.out.println(i + " " + "-> False");
            }
        }


    }
}
