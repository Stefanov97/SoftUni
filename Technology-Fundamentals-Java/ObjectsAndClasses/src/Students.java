import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;

        String getFirstName() {
            return this.firstName;
        }

        String getLastName() {
            return lastName;
        }

        String getHomeTown() {
            return homeTown;
        }

        int getAge() {
            return age;
        }

        void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        void setLastName(String lastName) {
            this.lastName = lastName;
        }

        void setHomeTown(String homeTown) {
            this.homeTown = homeTown;
        }

        void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> allStudents = new ArrayList<>();

        String line = scanner.nextLine();
        while (!"end".equals(line)) {
            String[] components = line.split(" +");
            String firstName = components[0];
            String lastName = components[1];
            int age = Integer.parseInt(components[2]);
            String homeTown = components[3];
            boolean studentNotFound = true;

            for (Student stud : allStudents) {
                if (stud.getFirstName().equals(firstName) && stud.getLastName().equals(lastName)) {
                    stud.setAge(age);
                    stud.setHomeTown(homeTown);
                    studentNotFound = false;
                    break;
                }
            }

            if (studentNotFound) {

                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(homeTown);
                allStudents.add(student);

            }

            line = scanner.nextLine();
        }
        String homeTown = scanner.nextLine();

        for (Student student : allStudents) {
            if (student.getHomeTown().equals(homeTown)) {
                System.out.printf("%s %s is %d years old", student.getFirstName(), student.getLastName(), student.getAge()).println();
            }

        }


    }
}
