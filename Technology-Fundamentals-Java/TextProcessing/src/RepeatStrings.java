import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" +");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String word = input[i];
            result.append(replace(word, word.length()));
        }
        System.out.println(result);
    }

    private static String replace(String word, int length) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            result.add(word);
        }
        return String.join("", result);
    }
}
