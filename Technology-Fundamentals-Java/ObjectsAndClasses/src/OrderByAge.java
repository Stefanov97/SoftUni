import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Person> persons = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split(" +");
            String name = tokens[0];
            String ID = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, ID, age);
            persons.add(person);
            line = scanner.nextLine();
        }
        persons.sort((f, s) -> f.getAge() - s.getAge());
        for (Person person : persons) {
            System.out.println(person.toString());
        }

    }

    static class Person {
        String name;
        String ID;
        int age;

        public int getAge() {
            return age;
        }

        Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.ID, this.age);
        }
    }
}
