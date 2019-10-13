import java.util.*;

public class AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String[] input = scanner.nextLine().split("\\s");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        students.forEach((name, grades) -> {
            System.out.print(name + " -> ");

            grades.forEach(grade -> System.out.printf("%.2f ", grade));
            double sum = 0;
            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            double avg = sum / grades.size();
            System.out.printf("(avg: %.2f)", avg);
            System.out.println();
        });
    }
}
