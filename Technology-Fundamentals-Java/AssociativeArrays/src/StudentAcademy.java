import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }


        }
        int index = 0;
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            double average = sum / entry.getValue().size();
            entry.getValue().set(index, average);

        }
        students.entrySet().stream().sorted((f, s) -> s.getValue().get(0).compareTo(f.getValue().get(0))).filter(a -> a.getValue().get(0) >= 4.50).forEach(e -> System.out.printf("%s -> %.2f%n", e.getKey(), e.getValue().get(0)));
    }
}
