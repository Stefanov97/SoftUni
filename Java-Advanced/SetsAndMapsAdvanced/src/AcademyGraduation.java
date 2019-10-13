import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s")).mapToDouble(Double::parseDouble).toArray();
            students.putIfAbsent(name, new ArrayList<>());
            for (double grade : grades) {
                students.get(name).add(grade);
            }
        }

        students.entrySet().stream().forEach(student -> {
            String name = student.getKey();
            List<Double> currentGrades = student.getValue();
            double sum = 0;
            for (Double grade : currentGrades) {
                sum += grade;
            }

            double avg = sum / currentGrades.size();
            String realSum = avg + "";
            System.out.printf("%s is graduated with %s", name, realSum).println();
        });
    }
}
