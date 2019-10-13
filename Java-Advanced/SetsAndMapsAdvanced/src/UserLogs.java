import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<>();
        String line = scanner.nextLine();
        while (!"end".equals(line)) {
            String[] tokens = line.split("\\s");

            String IP = tokens[0].substring(tokens[0].indexOf("=") + 1, tokens[0].length());
            String user = tokens[2].substring(tokens[2].indexOf("=") + 1, tokens[2].length());

            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(IP, 0);
            users.get(user).put(IP, users.get(user).get(IP) + 1);

            line = scanner.nextLine();
        }

        users.entrySet().stream().forEach(user -> {
            System.out.println(user.getKey() + ": ");

            List<Integer> positions = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                positions.add(i);
            }
            user.getValue().entrySet().stream().forEach(IP -> {
                String ip = IP.getKey();
                int count = IP.getValue();
                if (user.getValue().size() - 1 == positions.get(0)) {
                    System.out.println(String.format("%s => %d.", ip, count));
                } else {
                    System.out.print(String.format("%s => %d, ", ip, count));
                }
                positions.remove(0);
            });

        });
    }
}
