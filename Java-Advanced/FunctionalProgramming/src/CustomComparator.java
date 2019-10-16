import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Comparator<Integer> sortEvenAndOddInAscendingOrder = (f, s) -> {
            if (f % 2 == 0 && s % 2 != 0) {
                return -1;
            } else if (s % 2 == 0 && f % 2 != 0) {
                return 1;
            } else {
                return f - s;
            }
        };
        numbers.sort(sortEvenAndOddInAscendingOrder);
        numbers.forEach(n -> System.out.print(n + " "));
    }
}
