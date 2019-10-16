import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Consumer<Integer> printNumbers = element -> System.out.print(element + " ");
        Function<List<Integer>, List<Integer>> addFunction = collection -> {
            IntStream.range(0, collection.size()).forEach(i -> collection.set(i, collection.get(i) + 1));
            return collection;
        };
        Function<List<Integer>, List<Integer>> subtractFunction = collection -> {
            IntStream.range(0, collection.size()).forEach(position -> collection.set(position, collection.get(position) - 1));
            return collection;
        };

        Function<List<Integer>, List<Integer>> multiplyFunction = collection -> {
            IntStream.range(0, collection.size()).forEach(position -> collection.set(position, collection.get(position) * 2));
            return collection;
        };

        String line = scanner.nextLine();
        while (!"end".equals(line)) {
            switch (line) {
                case "add":
                    addFunction.apply(numbers);
                    break;
                case "subtract":
                    subtractFunction.apply(numbers);
                    break;
                case "multiply":
                    multiplyFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(printNumbers);
                    System.out.println();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
