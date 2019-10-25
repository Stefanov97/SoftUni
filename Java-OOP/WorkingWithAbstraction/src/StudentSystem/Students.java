package StudentSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class Students {
    private Map<String, Student> students;

    public Students() {
        students = new LinkedHashMap<>();
    }

    public boolean contains(String name) {

        return this.students.containsKey(name);
    }

    public void addStudent(String name, Student student) {
        this.students.put(name, student);
    }

    public Student getStudentByName(String name) {
        return this.students.get(name);
    }
}
