public class Employee {
    //Define a class Employee that holds the following information:
    // name, salary, position, department, email and age. The name, salary, position and department are mandatory while the rest are optional.

    String name;
    double salary;
    String position;
    String email;
    int age;
    String department;

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        email = "n/a";
        age = -1;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
