import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deciphering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cryptedBook = scanner.nextLine();
        String[] substrings = scanner.nextLine().split("\\s+");
        String wordToBeReplaced = substrings[0];
        String newWord = substrings[1];

        String regex = "^[d-z{}|#]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cryptedBook);
        if (matcher.find()) {
            String encryptedWord = "";
            encryptedWord = encrypt(cryptedBook, encryptedWord);
            encryptedWord = encryptedWord.replace(wordToBeReplaced, newWord);
            System.out.println(encryptedWord);
        } else {
            System.out.println("This is not the book you are looking for.");
        }
    }

    private static String encrypt(String cryptedBook, String encryptedWord) {
        for (int i = 0; i < cryptedBook.length(); i++) {
            char letter = cryptedBook.charAt(i);
            char newLetter = (char) (letter - 3);
            encryptedWord += newLetter;
        }
        return encryptedWord;
    }
}
