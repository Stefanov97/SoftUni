import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> personTreeSet = new TreeSet<>();
        HashSet<Person> personHashSet = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            personTreeSet.add(person);
            personHashSet.add(person);
        }
        System.out.println(personTreeSet.size());
        System.out.println(personHashSet.size());

    }
}
