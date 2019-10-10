import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            int newLetter = (int) letter + 3;
            char encryptedLetter = (char) newLetter;
            result.append(encryptedLetter);
        }
        System.out.println(result);
    }
}
