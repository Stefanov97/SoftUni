import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    static boolean isPalindrome(String number) {
        boolean isPalindrome = false;
        String[] forward = new String[number.length()];
        for (int i = 0; i < number.length(); i++) {
            forward[i] = String.valueOf(number.charAt(i));
        }
        String[] backward = new String[number.length()];
        for (int i = 0; i < number.length(); i++) { //101
            backward[i] = String.valueOf(number.charAt(number.length() - 1 - i));
        }
        if (Arrays.equals(backward, forward)) {
            isPalindrome = true;
        }
        if (isPalindrome) {
            isPalindrome = true;
        } else {
            isPalindrome = false;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String number = input;
            boolean output = isPalindrome(number);
            System.out.println(output);
            input = scanner.nextLine();
        }
    }
}
