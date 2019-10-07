import java.util.*;

public class OddOccurences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" +");
        int index = 0;
        for (String word : words) {
            words[index] = word.toLowerCase();
            index++;
        }

        Map<String, Integer> count = new LinkedHashMap<>();

        for (String word : words) {
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
            }
        }
        List<String> oddWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : count.entrySet()) {

            if (entry.getValue() % 2 != 0) {
                oddWords.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddWords));

    }
}
