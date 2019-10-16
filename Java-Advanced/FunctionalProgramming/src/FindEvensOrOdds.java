import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] tokens = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int lowerBound = tokens[0];
        int upperBound = tokens[1];
        String oddOrEven = reader.readLine();
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isOdd = n -> n % 2 != 0;
        Predicate<Integer> filter = isEven;
        filter = oddOrEven.equals("odd") ? isOdd : isEven;
        IntStream stream = IntStream.range(lowerBound, upperBound + 1);
        stream.boxed().filter(filter).forEach(e -> System.out.print(e + " "));
    }
}
