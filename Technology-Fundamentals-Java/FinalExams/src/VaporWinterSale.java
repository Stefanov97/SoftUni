import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VaporWinterSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> gamesWithPrice = new LinkedHashMap<>();
        Map<String, String> gamesWithDLCs = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            if (current.contains("-")) {
                String[] tokens = current.split("-");
                String name = tokens[0];
                double price = Double.parseDouble(tokens[1]);
                gamesWithPrice.put(name, price);
            } else if (current.contains(":")) {
                String[] tokens = current.split(":");
                String name = tokens[0];
                String DLCs = tokens[1];
                if (gamesWithPrice.containsKey(name)) {
                    double oldPrice = gamesWithPrice.get(name);
                    double newPrice = oldPrice * 1.20;
                    gamesWithPrice.put(name, newPrice);
                    gamesWithDLCs.put(name, DLCs);
                }
            }
        }
        for (Map.Entry<String, Double> entry : gamesWithPrice.entrySet()) {
            if (gamesWithDLCs.containsKey(entry.getKey())) {
                double oldPrice = gamesWithPrice.get(entry.getKey());
                gamesWithPrice.put(entry.getKey(), oldPrice * 0.5);
            } else {
                double oldPrice = gamesWithPrice.get(entry.getKey());
                gamesWithPrice.put(entry.getKey(), oldPrice * 0.8);
            }
        }
        gamesWithPrice.entrySet().stream().sorted((f, s) -> f.getValue().compareTo(s.getValue())).forEach(e -> {
            if (gamesWithDLCs.containsKey(e.getKey())) {
                System.out.printf("%s - %s - %.2f%n", e.getKey(), gamesWithDLCs.get(e.getKey()), e.getValue());
            }
        });

        gamesWithPrice.entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue())).forEach(e -> {
            if (!gamesWithDLCs.containsKey(e.getKey())) {
                System.out.printf("%s - %.2f%n", e.getKey(), e.getValue());
            }
        });
    }
}
