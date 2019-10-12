import java.util.*;

public class PractiseSessions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<String>> roads = new LinkedHashMap<>();

        while (!"END".equals(line)) {
            String[] tokens = line.split("->");
            String command = tokens[0];
            String road = tokens[1];
            switch (command) {
                case "Add": {
                    String racer = tokens[2];
                    roads.putIfAbsent(road, new ArrayList<>());
                    roads.get(road).add(racer);
                    break;
                }
                case "Move": {
                    String currentRoad = tokens[1];
                    String racer = tokens[2];
                    String nextRoad = tokens[3];

                    if (roads.get(currentRoad).contains(racer)) {
                        roads.get(currentRoad).remove(racer);
                        roads.get(nextRoad).add(racer);
                    }
                    break;
                }
                case "Close": {
                    roads.remove(road);
                    break;
                }
            }
            line = scanner.nextLine();
        }
        System.out.println("Practice sessions:");
        roads.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size();
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().forEach(r -> System.out.printf("++%s%n", r));

        });
    }
}
