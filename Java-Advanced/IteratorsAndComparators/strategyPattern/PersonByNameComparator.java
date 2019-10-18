import java.util.Comparator;

public class PersonByNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {

        if (p1.getName().length() - p2.getName().length() == 0) {
            return p1.getName().toLowerCase().charAt(0) - p2.getName().toLowerCase().charAt(0);
        } else {
            return p1.getName().length() - p2.getName().length();
        }
    }
}
