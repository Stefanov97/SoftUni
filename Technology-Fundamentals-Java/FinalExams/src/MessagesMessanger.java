import java.util.*;

public class MessagesMessanger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        Map<String, List<Integer>> users = new LinkedHashMap<>();
        while (!"Statistics".equals(line)) {
            String[] tokens = line.split("=");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);

                    if (!users.containsKey(username)) {
                        users.putIfAbsent(username, new ArrayList<>());
                        users.get(username).add(sent);
                        users.get(username).add(received);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];
                    if (users.containsKey(sender) && users.containsKey(receiver)) {
                        int oldSent = users.get(sender).get(0);
                        users.get(sender).set(0, oldSent + 1);
                        int newValueSent = users.get(sender).get(0) + users.get(sender).get(1);
                        if (newValueSent == capacity) {
                            System.out.println(sender + " reached the capacity!");
                            users.remove(sender);
                        }
                        int oldReceived = users.get(receiver).get(1);
                        users.get(receiver).set(1, oldReceived + 1);
                        int newValueReceived = users.get(receiver).get(1) + users.get(receiver).get(0);
                        if (newValueReceived == capacity) {
                            System.out.println(receiver + " reached the capacity!");
                            users.remove(receiver);
                        }
                    }
                    break;
                case "Empty":
                    if (username.equals("All")) {
                        List<String> toBeRemoved = new ArrayList<>();
                        for (Map.Entry<String, List<Integer>> user : users.entrySet()) {
                            String toRemove = user.getKey();
                            toBeRemoved.add(toRemove);
                        }
                        for (String user : toBeRemoved) {
                            users.remove(user);
                        }
                    } else {
                        users.remove(username);
                    }

                    break;
            }

            line = scanner.nextLine();
        }
        System.out.printf("Users count: %d%n", users.size());
        users.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().get(1).compareTo(f.getValue().get(1));
            if (result == 0) {
                result = f.getKey().compareTo(s.getKey());
            }
            return result;

        }).forEach(user -> {
            System.out.printf("%s - %d%n", user.getKey(), user.getValue().get(0) + user.getValue().get(1));
        });
    }
}
