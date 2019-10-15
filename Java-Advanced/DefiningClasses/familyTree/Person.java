import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Person {
    private String name;
    private String dateOfBirth;
    private LinkedHashSet<String> parents;
    private LinkedHashSet children;

    public Person(String name) {
        this.name = name;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet();
        this.dateOfBirth = "";
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setParents(LinkedHashSet<String> parents) {
        this.parents = parents;
    }

    public void setChildren(LinkedHashSet<String> children) {
        this.children = children;
    }

    public LinkedHashSet<String> getParents() {
        return parents;
    }

    public LinkedHashSet<String> getChildren() {
        return children;
    }
}
