import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"end of contests".equals(line)) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String pass = tokens[1];

            contests.putIfAbsent(contest, pass);
            line = scanner.nextLine();

        }
        Map<String, Map<String, Integer>> usersWithPoints = new LinkedHashMap<>();


        String secLine = scanner.nextLine();
        while (!"end of submissions".equals(secLine)) {
            String[] tokens = secLine.split("=>");
            String contest = tokens[0];
            String pass = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(pass)) {
                if (!usersWithPoints.containsKey(username)) {
                    usersWithPoints.putIfAbsent(username, new LinkedHashMap<>());
                    usersWithPoints.get(username).put(contest, points);
                } else {
                    if (usersWithPoints.get(username).containsKey(contest)) {
                        int oldPoints = usersWithPoints.get(username).get(contest);
                        if (points > oldPoints) {
                            usersWithPoints.get(username).put(contest, points);
                        }
                    } else {
                        usersWithPoints.get(username).put(contest, points);
                    }
                }

            }


            secLine = scanner.nextLine();
        }
        String bestCandidate = "";
        int bestSum = 0;
        for (Map.Entry<String, Map<String, Integer>> entry : usersWithPoints.entrySet()) {

            int currentSum = 0;
            for (Map.Entry<String, Integer> ent : entry.getValue().entrySet()) {
                currentSum += ent.getValue();
            }
            if (currentSum > bestSum) {
                bestSum = currentSum;
                bestCandidate = entry.getKey();
            }

        }

        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate, bestSum);
        System.out.println("Ranking: ");
        usersWithPoints.entrySet().stream().sorted((f, s) -> f.getKey().compareTo(s.getKey())).forEach(e -> {
            System.out.printf("%s%n", e.getKey());
            e.getValue().entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue())).forEach(j -> System.out.printf("#  %s -> %d%n", j.getKey(), j.getValue()));
        });
    }
}
