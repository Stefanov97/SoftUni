import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        char letter = input.charAt(0);
        System.out.print(letter);
        for (int i = 0; i < input.length(); i++) {

            if (letter != input.charAt(i)) {
                System.out.print(input.charAt(i));
                letter = input.charAt(i);
            }

        }

    }
}
