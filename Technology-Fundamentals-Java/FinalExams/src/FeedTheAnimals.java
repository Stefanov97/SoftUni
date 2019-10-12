import java.util.*;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Integer> animals = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();

        while (!"Last Info".equals(line)) {
            String[] tokens = line.split(":");
            String command = tokens[0];
            String name = tokens[1];
            String area = tokens[3];
            switch (command) {
                case "Add":
                    int foodLimit = Integer.parseInt(tokens[2]);
                    if (animals.containsKey(name)) {
                        int oldLimit = animals.get(name);
                        animals.put(name, oldLimit + foodLimit);
                    }
                    if (areas.containsKey(area) && !animals.containsKey(name)) {
                        int oldValue = areas.get(area);
                        areas.put(area, oldValue + 1);
                    }
                    areas.putIfAbsent(area, 1);
                    animals.putIfAbsent(name, foodLimit);
                    break;
                case "Feed":
                    int food = Integer.parseInt(tokens[2]);
                    if (animals.containsKey(name)) {
                        int oldFood = animals.get(name);
                        animals.put(name, oldFood - food);
                        if (animals.get(name) <= 0) {
                            System.out.printf("%s was successfully fed%n", name);
                            animals.remove(name);
                            int oldCount = areas.get(area);
                            areas.put(area, oldCount - 1);
                        }
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.printf("Animals:%n");
        animals.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(animal -> System.out.printf("%s -> %dg%n", animal.getKey(), animal.getValue()));

        System.out.printf("Areas with hungry animals:%n");
        areas.entrySet().stream().sorted((f, s) -> {
            return s.getValue().compareTo(f.getValue());
        }).forEach(e -> {
            if (e.getValue() > 0) {
                System.out.printf("%s : %d%n", e.getKey(), e.getValue());
            }
        });
    }
}
