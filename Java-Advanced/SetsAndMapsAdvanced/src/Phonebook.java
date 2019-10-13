import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!"search".equals(line)) {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String phone = tokens[1];
            phonebook.put(name, phone);

            line = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            String name = input;
            if (phonebook.containsKey(name)) {

                System.out.println(String.format("%s -> %s", name, phonebook.get(name)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", name));
            }


            input = scanner.nextLine();
        }
    }
}
