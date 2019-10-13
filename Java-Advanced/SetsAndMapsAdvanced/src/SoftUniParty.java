import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();
        while (!"PARTY".equals(input)) {
            if (Character.isDigit(input.charAt(0))) {
                vipGuests.add(input);
            } else {
                regularGuests.add(input);
            }
            input = scanner.nextLine();
        }
        String line = scanner.nextLine();
        while (!"END".equals(line)) {
            if (Character.isDigit(line.charAt(0))) {
                vipGuests.remove(line);
            } else {
                regularGuests.remove(line);
            }

            line = scanner.nextLine();
        }
        System.out.println(regularGuests.size() + vipGuests.size());
        vipGuests.forEach(guest -> System.out.println(guest));
        regularGuests.forEach(guest -> System.out.println(guest));
    }
}
