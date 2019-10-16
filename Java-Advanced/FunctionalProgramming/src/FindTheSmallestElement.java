import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> findMinIndex = collection -> {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < collection.size(); i++) {
                if (collection.get(i) <= min) {
                    min = collection.get(i);
                    minIndex = i;
                }
            }
            return minIndex;
        };

        System.out.println(findMinIndex.apply(numbers));
    }
}
