import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> allGuests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Party!".equals(line)) {
            String[] tokens = line.split("\\s+");
            String action = tokens[0];
            String whichPredicate = tokens[1];
            String criteria = tokens[2];
            Predicate<String> startsWith = name -> name.startsWith(criteria);
            Predicate<String> endsWith = name -> name.endsWith(criteria);

            if ("Remove".equals(action)) {
                switch (whichPredicate) {
                    case "StartsWith":
                        allGuests.removeIf(startsWith);
                        break;
                    case "EndsWith":
                        allGuests.removeIf(endsWith);
                        break;
                    case "Length":
                        Predicate<String> isValidLength = name -> name.length() == Integer.parseInt(criteria);
                        allGuests.removeIf(isValidLength);

                        break;
                }
            } else {
                switch (whichPredicate) {
                    case "StartsWith":
                        List<String> filtered = allGuests.stream().filter(startsWith).collect(Collectors.toList());
                        allGuests.addAll(filtered);
                        break;
                    case "EndsWith": {
                        List<String> filteredEndsWith = allGuests.stream().filter(endsWith).collect(Collectors.toList());
                        allGuests.addAll(filteredEndsWith);
                    }
                    break;
                    case "Length": {
                        Predicate<String> isValidLength = name -> name.length() == Integer.parseInt(criteria);
                        List<String> filteredEndsWith = allGuests.stream().filter(isValidLength).collect(Collectors.toList());
                        allGuests.addAll(filteredEndsWith);
                    }
                    break;
                }
            }

            line = scanner.nextLine();
        }
        Collections.sort(allGuests);
        if (allGuests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {

            System.out.print(String.join(", ", allGuests) + " are going to the party!");
        }
    }
}
