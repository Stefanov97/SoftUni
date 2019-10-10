import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(", ");
        List<String> validUsernames = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            boolean isValid = false;
            if (currentWord.length() >= 3 && currentWord.length() <= 16) {
                for (int j = 0; j < currentWord.length(); j++) {
                    char currentLetter = currentWord.charAt(j);
                    if (currentLetter == '-' || currentLetter == '_' || Character.isAlphabetic(currentLetter) || Character.isDigit(currentLetter)) {
                        isValid = true;

                    } else {
                        isValid = false;
                        break;
                    }
                }
            } else {
                continue;
            }
            if (isValid) {
                validUsernames.add(currentWord);
            }
        }
        for (String username : validUsernames) {
            System.out.println(username);
        }

    }
}
