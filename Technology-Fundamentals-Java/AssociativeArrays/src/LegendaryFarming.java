import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("motes", 0);
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        Map<String, Integer> junk = new HashMap<>();

        while (true) {
            boolean isObtained = false;
            String[] tokens = scanner.nextLine().split(" +");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();

                if (keyMaterials.containsKey(material)) {
                    int newValue = keyMaterials.get(material) + quantity;
                    keyMaterials.put(material, newValue);
                    if (keyMaterials.get(material) >= 250) {
                        isObtained = true;

                        break;
                    }
                } else {
                    if (!junk.containsKey(material)) {
                        junk.put(material, quantity);
                    } else {
                        int newValue = junk.get(material) + quantity;
                        junk.put(material, newValue);
                    }
                }

            }


            if (isObtained) {
                break;
            }
        }
        String legendaryItem = "";

        for (Map.Entry<String, Integer> entry : keyMaterials.entrySet()) {
            if (entry.getValue() >= 250) {
                String material = entry.getKey();
                switch (material) {
                    case "shards":
                        legendaryItem = "Shadowmourne";
                        break;
                    case "motes":
                        legendaryItem = "Dragonwrath";
                        break;
                    case "fragments":
                        legendaryItem = "Valanyr";
                        break;
                }
                keyMaterials.put(material, entry.getValue() - 250);
                break;
            }
        }
        System.out.println(String.format("%s obtained!", legendaryItem));
        keyMaterials.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());

            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));

        junk.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry -> System.out.printf("%s: %d%n", entry.getKey(), entry.getValue()));


    }
}
