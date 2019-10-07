import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> wordSynonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            String currentSynonym = scanner.nextLine();

            List<String> synonyms = wordSynonyms.get(word);
            if (synonyms == null) {
                synonyms = new ArrayList<>();
            }
            synonyms.add(currentSynonym);
            wordSynonyms.put(word, synonyms);

        }
        for (Map.Entry<String, List<String>> entry : wordSynonyms.entrySet()) {
            System.out.printf("%s - ", entry.getKey());
            System.out.println(String.join(", ", entry.getValue()));
        }

    }
}
