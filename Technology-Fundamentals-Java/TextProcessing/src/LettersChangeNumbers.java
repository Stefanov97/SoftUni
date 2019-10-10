import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        double sum = 0;
        for (String word : words) {
            char before = word.charAt(0);
            char after = word.charAt(word.length() - 1);
            int number = Integer.parseInt(word.substring(1, word.length() - 1));

            sum += calculateValue(before, after, number);
        }
        System.out.printf("%.2f", sum);

    }

    private static double calculateValue(char before, char after, int number) {
        double value = 0;
        if (Character.isUpperCase(before)) {
            value += number * 1.0 / ((before - 'A') + 1);
        } else {
            value += number * 1.0 * ((before - 'a') + 1);
        }
        if (Character.isUpperCase(after)) {
            value -= (after - 'A' + 1);
        } else {
            value += (after - 'a' + 1);
        }
        return value;
    }
}
