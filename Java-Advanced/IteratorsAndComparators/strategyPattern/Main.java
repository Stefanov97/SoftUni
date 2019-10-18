import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> personsByName = new TreeSet<>(new PersonByNameComparator());
        TreeSet<Person> persons = new TreeSet<>(new PersonByAgeComparator());

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            personsByName.add(person);
            persons.add(person);
        }
        for (Person person : personsByName) {
            System.out.println(String.format("%s %d", person.getName(), person.getAge()));
        }
        for (Person person : persons) {
            System.out.println(String.format("%s %d", person.getName(), person.getAge()));
        }
    }
}
