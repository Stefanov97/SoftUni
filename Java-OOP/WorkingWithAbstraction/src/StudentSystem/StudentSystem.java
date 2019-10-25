package StudentSystem;

public class StudentSystem {
    private Students students;


    public StudentSystem() {
        this.students = new Students();
    }


    public void ParseCommand(String[] args) {
        if (args[0].equals("Create")) {
            String name = args[1];
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!students.contains(name)) {
                Student student = new Student(name, age, grade);
                students.addStudent(name, student);
            }
        } else if (args[0].equals("Show")) {
            String name = args[1];
            if (students.contains(name)) {
                Student student = students.getStudentByName(name);
                System.out.println(student);
            }
        }
    }
}
