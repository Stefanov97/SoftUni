import java.util.*;
import java.util.stream.Collectors;

public class OpinionPoll {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        void setName(String name) {
            this.name = name;
        }

        void setAge(int age) {
            this.age = age;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" +");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            person.setName(name);
            person.setAge(age);
            persons.add(person);

        }


        persons.sort((f, s) -> f.getName().compareTo(s.getName()));

        for (Person person : persons) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %d", person.getName(), person.getAge()).println();

            }
        }

    }

}
