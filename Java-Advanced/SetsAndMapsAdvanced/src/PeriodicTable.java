import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] currentElements = scanner.nextLine().split("\\s");
            elements.addAll(Arrays.asList(currentElements));
        }
        elements.forEach(element -> System.out.print(element + " "));
    }
}
