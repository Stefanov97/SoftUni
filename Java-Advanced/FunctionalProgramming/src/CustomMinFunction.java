import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> findMin = collection -> {
            int min = Integer.MAX_VALUE;
            for (Integer number : collection) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        };

        System.out.println(findMin.apply(numbers));
    }
}
