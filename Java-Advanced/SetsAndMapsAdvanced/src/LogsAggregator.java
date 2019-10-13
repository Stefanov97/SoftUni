import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> usersTotalTime = new TreeMap();
        Map<String, TreeSet<String>> IPusers = new TreeMap();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s");
            String IP = tokens[0];
            String name = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            if (usersTotalTime.containsKey(name)) {
                usersTotalTime.put(name, usersTotalTime.get(name) + time);
            }
            usersTotalTime.putIfAbsent(name, time);
            IPusers.putIfAbsent(name, new TreeSet<>());
            IPusers.get(name).add(IP);

        }
        usersTotalTime.forEach((name, time) -> {
            System.out.print(String.format("%s: %d ", name, time));

            TreeSet<String> currentSet = IPusers.get(name);
            int index = 0;
            System.out.print("[");
            for (String ip : currentSet) {

                if (index++ == currentSet.size() - 1) {
                    System.out.println(String.format("%s]", ip));

                } else {
                    System.out.print(String.format("%s, ", ip));
                }

            }

        });
    }
}
