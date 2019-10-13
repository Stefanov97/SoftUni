import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyItems = new TreeMap<>();
        keyItems.put("shards", 0);
        keyItems.put("motes", 0);
        keyItems.put("fragments", 0);
        Map<String, Integer> junk = new TreeMap<>();
        boolean isObtained = false;
        String obtaintedItem = "";
        while (true) {
            String[] tokens = scanner.nextLine().split("\\s");
            for (int i = 0; i < tokens.length; i += 2) {
                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("motes") || material.equals("fragments")) {
                    if (keyItems.containsKey(material)) {
                        keyItems.put(material, keyItems.get(material) + quantity);
                    }
                    if (keyItems.get(material) >= 250) {
                        isObtained = true;
                        keyItems.put(material, keyItems.get(material) - 250);
                        switch (material) {
                            case "shards":
                                obtaintedItem = "Shadowmourne";
                                break;
                            case "motes":
                                obtaintedItem = "Dragonwrath";
                                break;
                            case "fragments":
                                obtaintedItem = "Valanyr";
                                break;
                        }
                        break;
                    }
                } else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
                }

            }
            if (isObtained) {
                System.out.println(obtaintedItem + " obtained!");
                break;
            }
        }
        keyItems.entrySet().stream().sorted((f, s) -> {
            return s.getValue().compareTo(f.getValue());
        }).forEach(element -> {
            System.out.printf("%s: %d", element.getKey(), element.getValue()).println();
        });

        junk.entrySet().forEach(element -> {
            System.out.printf("%s: %d", element.getKey(), element.getValue()).println();
        });
    }
}
