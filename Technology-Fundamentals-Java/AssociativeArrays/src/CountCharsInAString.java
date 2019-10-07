import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" +");

        Map<Character, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char letter = word.charAt(j);
                if (letter != ' ') {
                    if (!count.containsKey(letter)) {
                        count.put(letter, 1);
                    } else {
                        int newValue = count.get(letter) + 1;
                        count.put(letter, newValue);
                    }
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
