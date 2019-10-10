import java.util.Scanner;

public class PasswordValidator {
    static void isVallidPassword(String password) {
        int charactersCount = 0;
        int digitsCount = 0;
        int notValidSymbols = 0;
        boolean isValidPassword = true;
        for (int i = 0; i < password.length(); i++) {
            boolean isLetter = false;
            boolean isDigit = false;
            char letter = password.charAt(i);
            charactersCount++;
            if (((int) letter >= 65 && (int) letter <= 95) || ((int) letter >= 97 && (int) letter <= 122)) {
                isLetter = true;
            } else if (((int) letter >= 48 && (int) letter <= 57)) {
                isDigit = true;
                digitsCount++;
            }
            if (!isDigit && !isLetter) {
                notValidSymbols++;
            }
        }
        if (charactersCount < 6 || charactersCount > 10) {
            System.out.println("Password must be between 6 and 10 characters");
            isValidPassword = false;
        }
        if (notValidSymbols != 0) {
            System.out.println("Password must consist only of letters and digits");
            isValidPassword = false;
        }
        if (digitsCount < 2) {
            System.out.println("Password must have at least 2 digits");
            isValidPassword = false;
        }
        if (isValidPassword) {
            System.out.println("Password is valid");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        isVallidPassword(password);
    }
}
