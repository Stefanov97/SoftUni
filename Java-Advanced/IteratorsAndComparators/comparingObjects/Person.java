public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int result = 0;
        if (this.name.compareTo(other.name) == 0) {
            result = this.age - other.age;

        } else {
            return this.name.compareTo(other.name);
        }
        if (result == 0) {
            result = this.town.compareTo(other.town);
        } else {
            return this.age - other.age;
        }
        return result;
    }
}
