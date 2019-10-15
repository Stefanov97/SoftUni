import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameToPrint = scanner.nextLine();


        String line = scanner.nextLine();

        HashSet<String> firstAppearance = new LinkedHashSet<>();
        Map<String, HashSet<String>> parentAndKid = new LinkedHashMap<>();
        HashSet<Person> persons = new LinkedHashSet<>();
        while (!"End".equals(line)) {
            if (line.contains("-")) {
                String[] tokens = line.split(" - ");
                String nameOrDateParent = tokens[0];
                String nameOrDateChild = tokens[1];
                firstAppearance.add(nameOrDateParent);
                firstAppearance.add(nameOrDateChild);
                parentAndKid.putIfAbsent(nameOrDateParent, new LinkedHashSet<>());
                parentAndKid.get(nameOrDateParent).add(nameOrDateChild);
            } else {
                String[] tokens = line.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String dateOfBirth = tokens[2];
                firstAppearance.add(name);
                Person person = new Person(name);
                person.setDateOfBirth(dateOfBirth);
                persons.add(person);
            }
            line = scanner.nextLine();
        }
        Map<String, LinkedHashSet<String>> parentWithChild = new LinkedHashMap<>();

        for (Map.Entry<String, HashSet<String>> entry : parentAndKid.entrySet()) {
            String parent = entry.getKey();
            HashSet<String> childs = entry.getValue();
            if (parent.contains("/")) {
                for (Person person : persons) {
                    if (person.getDateOfBirth().equals(parent)) {
                        parent = person.getName();
                        parentWithChild.putIfAbsent(parent, new LinkedHashSet<>());
                        break;
                    }
                }
            } else {
                parentWithChild.putIfAbsent(parent, new LinkedHashSet<>());
            }

            for (String child : childs) {
                if (child.contains("/")) {
                    for (Person person : persons) {
                        if (person.getDateOfBirth().equals(child)) {
                            child = person.getName();
                            parentWithChild.putIfAbsent(parent, new LinkedHashSet<>());
                            parentWithChild.get(parent).add(child);
                        }
                    }
                } else {
                    parentWithChild.putIfAbsent(parent, new LinkedHashSet<>());
                    parentWithChild.get(parent).add(child);
                }
            }
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : parentWithChild.entrySet()) {
            String parent = entry.getKey();
            LinkedHashSet<String> chilrens = entry.getValue();
            LinkedHashSet<String> parents = new LinkedHashSet<>();
            for (Person person : persons) {
                if (person.getName().equals(parent)) {
                    person.setChildren(chilrens);
                }
            }
            for (String child : chilrens) {
                for (Person person : persons) {
                    if (person.getName().equals(child)) {
                        parents.add(parent);
                        if (person.getParents().isEmpty()) {
                            person.setParents(parents);
                        } else {
                            person.getParents().add(parent);
                        }
                    }
                }
            }
        }
        if (nameToPrint.contains("/")) {
            for (Person person : persons) {
                if (nameToPrint.equals(person.getDateOfBirth())) {
                    nameToPrint = person.getName();
                    break;
                }
            }
        }

        for (Person person : persons) {
            if (nameToPrint.equals(person.getName())) {
                System.out.println(String.format("%s %s", person.getName(), person.getDateOfBirth()));
                System.out.println("Parents:");

                for (String parent : person.getParents()) {
                    String parentDate = "";
                    for (Person person1 : persons) {
                        if (parent.equals(person1.getName())) {
                            parentDate = person1.getDateOfBirth();
                            break;
                        }
                    }

                    System.out.println(String.format("%s %s", parent, parentDate));
                }
                System.out.println("Children:");

                for (String child : person.getChildren()) {
                    String childDate = "";
                    for (Person person1 : persons) {
                        if (child.equals(person1.getName())) {
                            childDate = person1.getDateOfBirth();
                            break;
                        }
                    }
                    System.out.println(String.format("%s %s", child, childDate));
                }
            }
        }
    }
}
