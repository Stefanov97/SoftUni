import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<String>> sides = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(line)) {
            if (line.contains("|")) {
                String[] tokens = line.split(" \\| ");
                String forceSide = tokens[0];
                String forceUser = tokens[1];
                boolean isPresent = false;
                if (!sides.containsKey(forceSide)) {
                    sides.put(forceSide, new ArrayList<>());

                }
                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                    if (entry.getValue().contains(forceUser)) {
                        isPresent = true;
                    }
                }
                if (!isPresent) {
                    sides.get(forceSide).add(forceUser);
                }
            } else {
                String[] tokens = line.split(" -> ");
                String forceSide = tokens[1];
                String forceUser = tokens[0];
                boolean isPresent = false;
                for (Map.Entry<String, List<String>> entry : sides.entrySet()) {

                    if (entry.getValue().contains(forceUser)) {
                        entry.getValue().remove(forceUser);

                        if (!sides.containsKey(forceSide)) {
                            sides.put(forceSide, new ArrayList<>());
                            sides.get(forceSide).add(forceUser);
                        } else {
                            sides.get(forceSide).add(forceUser);
                        }
                        isPresent = true;
                        break;
                    }


                }
                if (!isPresent) {
                    sides.putIfAbsent(forceSide, new ArrayList<>());
                    sides.get(forceSide).add(forceUser);

                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }


            line = scanner.nextLine();
        }

        sides.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size();
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;
        }).forEach(e -> {
            if (!e.getValue().isEmpty()) {
                System.out.printf("Side: %s, Members: %d%n", e.getKey(), e.getValue().size());
                e.getValue().stream().sorted((a, b) -> a.compareTo(b)).forEach(name -> System.out.printf("! %s%n", name));
            }
        });
    }
}
