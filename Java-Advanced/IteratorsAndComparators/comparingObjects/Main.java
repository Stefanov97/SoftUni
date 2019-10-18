import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Person> persons = new ArrayList<>();
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            Person person = new Person(name, age, town);
            persons.add(person);
            line = scanner.nextLine();
        }
        int indexOfPersonToCompare = Integer.parseInt(scanner.nextLine()) - 1;
        int numberEqual = 0;
        Person toFind = persons.get(indexOfPersonToCompare);
        for (Person person : persons) {
            if (toFind.compareTo(person) == 0) {
                numberEqual++;
            }
        }
        if (numberEqual == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", numberEqual, persons.size() - numberEqual, persons.size());
        }
    }
}
