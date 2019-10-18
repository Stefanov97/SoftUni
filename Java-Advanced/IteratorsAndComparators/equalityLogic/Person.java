public class Person implements Comparable<Person> {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person)) {
            return false;
        }
        Person otherPerson = (Person) other;
        return this.name.equals(otherPerson.getName()) && this.age == otherPerson.getAge();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() * 31 + this.age * 17; // For example...
    }


    @Override
    public int compareTo(Person other) {
        if (this.name.compareTo(other.getName()) == 0) {
            return this.age - other.getAge();
        } else {
            return this.name.compareTo(other.getName());
        }
    }
}


