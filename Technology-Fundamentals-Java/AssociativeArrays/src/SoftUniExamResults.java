import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> results = new LinkedHashMap<>();
        Map<String, Integer> submissions = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"exam finished".equals(line)) {
            String[] tokens = line.split("-");
            String username = tokens[0];
            String bannedOrNot = tokens[1];
            if (bannedOrNot.equals("banned")) {
                results.remove(username);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                if (!submissions.containsKey(language)) {
                    submissions.put(language, 1);
                } else {
                    int value = submissions.get(language) + 1;
                    submissions.put(language, value);
                }

                if (!results.containsKey(username)) {
                    results.put(username, points);
                } else {
                    int oldPoints = results.get(username);
                    if (points > oldPoints) {
                        results.put(username, points);
                    }
                }


            }


            line = scanner.nextLine();
        }
        System.out.println("Results:");
        results.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> System.out.printf("%s | %d%n", e.getKey(), e.getValue()));

        System.out.println("Submissions:");
        submissions.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue()));
    }
}
