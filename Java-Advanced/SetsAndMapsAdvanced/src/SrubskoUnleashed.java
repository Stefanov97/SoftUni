import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([A-Za-z]+\\s?[A-Za-z]+?\\s?[A-Za-z]+?)\\s@([A-Za-z]+\\s?[A-Za-z]+?\\s?[A-Za-z]+?)\\s(\\d+)\\s(\\d+)$";

        Pattern pattern = Pattern.compile(regex);


        String line = scanner.nextLine();
        Map<String, LinkedHashMap<String, Integer>> output = new LinkedHashMap<>();

        while (!"End".equals(line)) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String name = matcher.group(1);
                String town = matcher.group(2);
                int ticketPrice = Integer.parseInt(matcher.group(3));
                int ticketCount = Integer.parseInt(matcher.group(4));
                int totalPrice = ticketPrice * ticketCount;
                output.putIfAbsent(town, new LinkedHashMap<>());
                if (output.get(town).containsKey(name)) {
                    output.get(town).put(name, output.get(town).get(name) + totalPrice);
                } else {
                    output.get(town).put(name, totalPrice);
                }

            }


            line = scanner.nextLine();
        }
        output.entrySet().forEach(element -> {
            System.out.printf("%s", element.getKey()).println();
            Map<String, Integer> currentTown = element.getValue();
            currentTown.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(e -> {
                System.out.printf("#  %s -> %d", e.getKey(), e.getValue()).println();
            });
        });
    }
}
