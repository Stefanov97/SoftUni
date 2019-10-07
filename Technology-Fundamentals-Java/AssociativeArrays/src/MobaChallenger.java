import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MobaChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> players = new LinkedHashMap<>();

        while (!"Season end".equals(line)) {
            if (line.contains("->")) {
                String[] tokens = line.split(" -> ");
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                players.putIfAbsent(name, new LinkedHashMap<>());
                if (!players.get(name).containsKey(position)) {
                    players.get(name).put(position, skill);
                } else {
                    int oldSkill = players.get(name).get(position);
                    if (skill > oldSkill) {
                        players.get(name).put(position, skill);
                    }
                }

            } else {
                String[] tokens = line.split(" vs ");
                String firstName = tokens[0];
                String secondName = tokens[1];
            }

            line = scanner.nextLine();
        }

        players.entrySet().stream().forEach(e -> {

            e.getValue().entrySet().stream().sorted((f, s) -> s.getValue().compareTo(f.getValue()));

            System.out.printf("%s: %d skill%n", e.getKey(), e.getValue().get(e.getKey()));
            e.getValue().entrySet().stream().sorted((f, s) -> {
                int result = s.getValue().compareTo(f.getValue());
                if (result == 0) {
                    result = f.getKey().compareTo(s.getKey());
                }
                return result;
            }).forEach(p -> {
                System.out.printf("- %s <::> %d%n", p.getKey(), p.getValue());
            });
        });
    }
}
