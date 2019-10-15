
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String currentName = tokens[0];
            int currentAge = Integer.parseInt(tokens[1]);
            if (currentAge > 30) {
                Person person = new Person(currentName, currentAge);
                people.add(person);

            }
        }
        people.sort((f, s) -> f.getName().compareTo(s.getName()));
        people.forEach(person -> System.out.println(String.format("%s - %d", person.getName(), person.getAge())));
    }
}
