import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class aMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"stop".equals(line)) {
            String metal = line;
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!materials.containsKey(metal)) {
                materials.put(metal, quantity);
            } else {
                int newValue = materials.get(metal) + quantity;
                materials.put(metal, newValue);
            }

            line = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : materials.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }

    }
}
