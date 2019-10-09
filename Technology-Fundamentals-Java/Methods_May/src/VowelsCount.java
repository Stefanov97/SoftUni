import java.util.Scanner;

public class VowelsCount {
    static int vowelsCount(String input) {
        int vowelCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (String.valueOf(letter).equalsIgnoreCase("A") || String.valueOf(letter).equalsIgnoreCase("E")
                    || String.valueOf(letter).equalsIgnoreCase("I") || String.valueOf(letter).equalsIgnoreCase("O") ||
                    String.valueOf(letter).equalsIgnoreCase("U") || String.valueOf(letter).equalsIgnoreCase("Y")) {
                vowelCounter++;
            }
        }
        return vowelCounter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //A, E, I, O, U,Y
        String input = scanner.nextLine();

        System.out.println(vowelsCount(input));
    }
}
