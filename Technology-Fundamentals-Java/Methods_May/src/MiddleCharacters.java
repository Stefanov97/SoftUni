import java.util.Scanner;

public class MiddleCharacters {
    static void getMiddleCharacter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.length() % 2 == 0) {
                if (i == input.length() / 2) {
                    System.out.print(input.charAt(i - 1));
                    System.out.print(input.charAt(i));
                }
            } else {
                if (i == input.length() / 2) {
                    System.out.println(input.charAt(i));
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        getMiddleCharacter(input);

    }
}
