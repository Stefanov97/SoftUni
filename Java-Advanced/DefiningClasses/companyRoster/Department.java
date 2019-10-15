import java.util.ArrayList;
import java.util.List;

public class Department {
    List<Employee> employees;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public double getAverageSalary() {
        return this.employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }
}
