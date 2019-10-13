import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstSize = scanner.nextInt();
        int secondSize = scanner.nextInt();
        scanner.nextLine();
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < firstSize; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSize; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));
        }

        first.retainAll(second);
        first.forEach(number -> System.out.print(number + " "));
    }
}
