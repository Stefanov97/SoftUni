import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = calcSum(numbers, 0);
        System.out.println(sum);
    }

    private static int calcSum(List<Integer> numbers, int index) {
        if (index == numbers.size() - 1) {
            return numbers.get(index);
        }
        return numbers.get(index) + calcSum(numbers, index + 1);
    }
}
