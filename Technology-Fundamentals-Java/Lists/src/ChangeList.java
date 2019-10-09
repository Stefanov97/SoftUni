import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"end".equals(line)) {

            String[] input = line.split(" +");
            String command = input[0];

            if ("Delete".equals(command)) {
                int element = Integer.parseInt(input[1]); // Integer.valueOf
                while (numbers.contains(element)) {
                    numbers.remove(Integer.valueOf(element));
                }
            } else {
                int index = Integer.parseInt(input[2]);
                int element = Integer.parseInt(input[1]);
                if (index < numbers.size()) {
                    numbers.add(index, element);
                }
            }

            line = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
