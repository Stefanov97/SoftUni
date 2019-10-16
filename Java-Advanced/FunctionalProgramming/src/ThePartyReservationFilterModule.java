import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());

        Map<String, Predicate<String>> filters = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!"Print".equals(line)) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String whichPredicate = tokens[1];
            String criteria = tokens[2];
            Predicate<String> startsWith = name -> name.startsWith(criteria);
            Predicate<String> endsWith = name -> name.endsWith(criteria);
            String filterName = whichPredicate + criteria;
            switch (command) {

                case "Add filter":
                    if (whichPredicate.equals("Starts with")) {
                        filters.put(filterName, startsWith);
                    } else if (whichPredicate.equals("Ends with")) {
                        filters.put(filterName, endsWith);
                    } else if (whichPredicate.equals("Length")) {
                        Predicate<String> isValidLength = name -> name.length() == Integer.parseInt(criteria);
                        filters.put(filterName, isValidLength);
                    } else {
                        Predicate<String> isContaining = name -> name.contains(criteria);
                        filters.put(filterName, isContaining);
                    }
                    break;
                case "Remove filter":
                    filters.remove(filterName);
                    break;

            }
            line = scanner.nextLine();
        }
        for (Map.Entry<String, Predicate<String>> entry : filters.entrySet()) {
            Predicate<String> currentPredicate = entry.getValue();
            guests.removeIf(currentPredicate);
        }

        System.out.println(String.join(" ", guests));
    }
}
