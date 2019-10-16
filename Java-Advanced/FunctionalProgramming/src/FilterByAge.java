import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> person = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            person.put(name, age);

        }
        String olderOrYounger = reader.readLine();
        int requiredAge = Integer.parseInt(reader.readLine());
        String[] whatToPrint = reader.readLine().split("\\s");

        Predicate<Map.Entry<String, Integer>> isOlderThan = e -> e.getValue() >= requiredAge;
        Predicate<Map.Entry<String, Integer>> isYoungerThan = e -> e.getValue() <= requiredAge;
        Consumer<Map.Entry<String, Integer>> printNameAndAge = p -> System.out.printf("%s - %d%n", p.getKey(), p.getValue());
        Consumer<Map.Entry<String, Integer>> printName = p -> System.out.printf("%s%n", p.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = p -> System.out.printf("%d%n", p.getValue());

        Predicate<Map.Entry<String, Integer>> finalCompare = isOlderThan;
        if (olderOrYounger.equals("younger")) {
            finalCompare = isYoungerThan;
        }
        Consumer<Map.Entry<String, Integer>> finalPrint = printNameAndAge;
        if (whatToPrint.length == 1) {
            switch (whatToPrint[0]) {
                case "name":
                    finalPrint = printName;
                    break;
                case "age":
                    finalPrint = printAge;
                    break;
            }
        }
        person.entrySet().stream().filter(finalCompare).forEach(finalPrint);
    }
}
