import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        List<String> wordsWithDescription = Arrays.stream(scanner.nextLine().split(" \\| ")).collect(Collectors.toList());

        for (int i = 0; i < wordsWithDescription.size(); i++) {
            String[] currentWordWithDescription = wordsWithDescription.get(i).split(": ");
            String currentWord = currentWordWithDescription[0];
            String currentDescription = currentWordWithDescription[1];
            dictionary.putIfAbsent(currentWord, new ArrayList<>());
            dictionary.get(currentWord).add(currentDescription);
        }
        String[] wordsToCheck = scanner.nextLine().split(" \\| ");
        for (int i = 0; i < wordsToCheck.length; i++) {
            String currentWord = wordsToCheck[i];
            if (dictionary.containsKey(currentWord)) {
                System.out.println(currentWord);
                dictionary.get(currentWord).stream().sorted(((f, s) -> s.length() - f.length())).forEach(e -> System.out.println(" -" + e));
            }
        }
        String command = scanner.nextLine();
        switch (command) {
            case "List":
                dictionary.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(e -> System.out.print(e.getKey() + " "));
                break;

        }
    }
}
