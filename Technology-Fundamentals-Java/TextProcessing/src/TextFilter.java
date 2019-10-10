import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();

        for (int i = 0; i < bannedWords.length; i++) {
            input = input.replace(bannedWords[i], repeat("*", bannedWords[i].length()));
        }
        System.out.println(input);
    }

    private static String repeat(String word, int length) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(word);
        }
        return String.join("", result);
    }
}
