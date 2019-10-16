import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int upperBound = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersToCheck = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Predicate<Integer> isDivisibleBy = number -> {
            boolean isDivisible = true;
            for (int i = 0; i < numbersToCheck.size(); i++) {
                if (number % numbersToCheck.get(i) != 0) {
                    isDivisible = false;
                    break;
                }
            }
            return isDivisible;

        };
        IntStream.range(1, upperBound + 1).boxed().filter(isDivisibleBy).forEach(element -> System.out.print(element + " "));
    }
}
