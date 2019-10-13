import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, String> emails = new LinkedHashMap<>();

        while (!"stop".equals(line)) {
            String name = line;
            String email = scanner.nextLine();
            int indexOfDot = email.lastIndexOf(".");
            String domain = email.substring(indexOfDot + 1, email.length()).toLowerCase();
            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                emails.put(name, email);
            }

            line = scanner.nextLine();
        }
        emails.forEach((name, email) -> {
            System.out.println(String.format("%s -> %s", name, email));
        });
    }
}
