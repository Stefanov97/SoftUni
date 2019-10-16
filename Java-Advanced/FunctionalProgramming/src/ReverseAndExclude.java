import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int divisibleNumber = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> divisibleByGivenNumber = element -> element % divisibleNumber == 0;
        Collections.reverse(numbers);
        numbers.removeIf(divisibleByGivenNumber);
        numbers.forEach(element -> System.out.print(element + " "));

    }
}
