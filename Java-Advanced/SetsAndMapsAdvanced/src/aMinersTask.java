import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinersTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Integer> metals = new LinkedHashMap<>();

        while (!"stop".equals(line)) {
            String metal = line;
            int quantity = Integer.parseInt(scanner.nextLine());


            if (metals.containsKey(metal)) {
                metals.put(metal, metals.get(metal) + quantity);

            }
            metals.putIfAbsent(metal, quantity);
            line = scanner.nextLine();
        }
        metals.forEach((metal, quantity) -> System.out.println(String.format("%s -> %s", metal, quantity)));
    }
}
