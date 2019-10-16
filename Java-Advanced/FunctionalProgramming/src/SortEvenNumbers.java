import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        Predicate<Integer> isEven = d -> d % 2 == 0;
        Consumer<Integer> printNumber = d -> System.out.print(d + ", ");
        Consumer<Integer> printLastNumber = d -> System.out.print(d);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numsToString = reader.readLine().split(", ");
        List<Integer> evenNumbers = Arrays.stream(numsToString).map(Integer::parseInt).filter(isEven).collect(Collectors.toList());
        List<String> stringStream = evenNumbers.stream().map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", stringStream));

        List<String> sortedEvenNums = evenNumbers.stream().sorted(Integer::compareTo).map(String::valueOf).collect(Collectors.toList());
        System.out.println(String.join(", ", sortedEvenNums));
    }
}
