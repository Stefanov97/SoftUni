
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new TreeMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee current = new Employee(name, salary, position, department);

            if (tokens.length == 5) {
                if (Character.isDigit(tokens[4].charAt(0))) {
                    int age = Integer.parseInt(tokens[4]);
                    current.setAge(age);

                } else {
                    String email = tokens[4];
                    current.setEmail(email);
                }
            } else if (tokens.length == 6) {
                String email = tokens[4];
                current.setEmail(email);
                int age = Integer.parseInt(tokens[5]);
                current.setAge(age);
            }

            departments.putIfAbsent(department, new Department());
            departments.get(department).addEmployee(current);

        }
        departments.entrySet().stream().sorted((f, s) -> Double.compare(s.getValue().getAverageSalary(), f.getValue().getAverageSalary())).limit(1).forEach(e -> {
            System.out.printf("Highest Average Salary: %s%n", e.getKey());

            Department current = e.getValue();
            current.employees.stream().sorted((f, s) -> Double.compare(s.getSalary(), f.getSalary())).forEach(emp ->
                    System.out.printf("%s %.2f %s %d%n", emp.getName(), emp.getSalary(), emp.getEmail(), emp.getAge()));
        });
    }
}
