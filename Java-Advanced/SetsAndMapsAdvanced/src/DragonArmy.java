import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, TreeMap<String, List<Integer>>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s");
            String type = tokens[0];
            String name = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);
            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).putIfAbsent(name, new ArrayList<>());
            dragons.get(type).get(name).add(0);
            dragons.get(type).get(name).add(0);
            dragons.get(type).get(name).add(0);
            for (int j = dragons.get(type).get(name).size() - 1; j > 2; j--) {
                dragons.get(type).get(name).remove(j);
            }
            dragons.get(type).get(name).set(0, damage);
            dragons.get(type).get(name).set(1, health);
            dragons.get(type).get(name).set(2, armor);
        }

        dragons.entrySet().forEach(entry -> {
            TreeMap<String, List<Integer>> currentType = entry.getValue();
            double avgDamage = 0;
            double avgHealth = 0;
            double avgArmor = 0;
            for (Map.Entry<String, List<Integer>> dragon : currentType.entrySet()) {
                List<Integer> currentStats = dragon.getValue();
                avgDamage += currentStats.get(0);
                avgHealth += currentStats.get(1);
                avgArmor += currentStats.get(2);
            }
            avgDamage = avgDamage * 1.0 / currentType.size();
            avgHealth = avgHealth * 1.0 / currentType.size();
            avgArmor = avgArmor * 1.0 / currentType.size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)", entry.getKey(), avgDamage, avgHealth, avgArmor).println();

            currentType.entrySet().forEach(dragon -> {
                int damage = dragon.getValue().get(0);
                int health = dragon.getValue().get(1);
                int armor = dragon.getValue().get(2);
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d", dragon.getKey(), damage, health, armor).println();
            });
        });
    }
}
