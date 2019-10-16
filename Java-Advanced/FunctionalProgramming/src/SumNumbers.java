import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersToString = reader.readLine().split(", ");
        Function<String, Integer> parse = e -> Integer.parseInt(e);
        List<Integer> integers = Arrays.stream(numbersToString).map(parse).collect(Collectors.toList());
        System.out.println("Count = " + integers.size());

        Integer sum = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);
    }
}
