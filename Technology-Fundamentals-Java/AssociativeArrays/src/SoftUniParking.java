import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String registerOrUnregister = tokens[0];
            String username = tokens[1];

            switch (registerOrUnregister) {
                case "register":
                    String number = tokens[2];
                    if (!users.containsKey(username)) {
                        users.put(username, number);
                        System.out.printf("%s registered %s successfully%n", username, number);
                    } else {
                        System.out.printf("ERROR: already registered with plate number %s%n", number);
                    }

                    break;

                default:
                    if (!users.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }

        }
        for (Map.Entry<String, String> entry : users.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }

    }
}
