import java.util.*;
import java.util.stream.Collectors;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!"end".equals(line)) {
            String[] tokens = line.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
                courses.get(courseName).add(studentName);
            } else {
                courses.get(courseName).add(studentName);
            }

            line = scanner.nextLine();
        }

        courses.entrySet().stream().sorted((f, s) -> Integer.compare(s.getValue().size(), f.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry.getValue().stream().sorted(String::compareTo).forEach(p -> System.out.println(String.format("-- %s", p)));
                });

    }
}
