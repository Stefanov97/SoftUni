import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, Map<String, Integer>> users = new LinkedHashMap<>();
        Map<String, Integer> individual = new LinkedHashMap<>();


        while (!"no more time".equals(line)) {
            String[] tokens = line.split(" -> ");
            String name = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);


            users.putIfAbsent(contest, new LinkedHashMap<>());
            if (users.get(contest).containsKey(name)) {
                int oldPoints = users.get(contest).get(name);
                if (points > oldPoints) {
                    users.get(contest).put(name, points);
                    int diff = points - oldPoints;
                    int curr = individual.get(name);
                    individual.put(name, curr + diff);

                }
            } else {
                users.get(contest).put(name, points);
                if (!individual.containsKey(name)) {
                    individual.put(name, points);
                } else {
                    int current = individual.get(name);
                    individual.put(name, current + points);
                }


            }


            line = scanner.nextLine();
        }

        users.entrySet().stream().forEach(e -> {
            e.getValue().entrySet().stream().sorted((f, s) -> {
                int result = s.getValue().compareTo(f.getValue());
                if (result == 0) {
                    result = f.getKey().compareTo(s.getKey());
                }
                return result;
            });

            System.out.printf("%s: %d participants%n", e.getKey(), e.getValue().size());
            List<Integer> positions = new ArrayList<>();
            for (int i = 1; i <= 50; i++) {
                positions.add(i);
            }


            e.getValue().entrySet().stream().sorted((a, b) -> {
                int result = b.getValue().compareTo(a.getValue());
                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }
                return result;

            }).forEach(p -> {
                System.out.printf("%d. %s <::> %d%n", positions.get(0), p.getKey(), p.getValue());
                positions.remove(0);
            });

        });
        System.out.println("Individual standings:");
        List<Integer> positions = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            positions.add(i);
        }
        individual.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().compareTo(f.getValue());
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            System.out.printf("%d. %s -> %d%n", positions.get(0), e.getKey(), e.getValue());
            positions.remove(0);
        });
    }
}
