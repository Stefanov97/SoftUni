import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            String[] tokens = line.split(" +");
            String command = tokens[0];

            switch (command) {
                case "Switch": {
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.size()) {
                        int oldNumber = numbers.get(index);
                        int newNumber = oldNumber * -1;

                        numbers.set(index, newNumber);
                    }
                }
                break;
                case "Change":
                    int index = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);

                    if (index >= 0 && index < numbers.size()) {
                        numbers.set(index, value);
                    }
                    break;
                case "Sum":
                    String whatToSum = tokens[1];
                    int sum = 0;
                    if (whatToSum.equals("Negative")) {
                        for (Integer number : numbers) {
                            if (number < 0) {
                                sum += number;
                            }
                        }
                    } else if (whatToSum.equals("Positive")) {
                        for (Integer number : numbers) {
                            if (number >= 0) {
                                sum += number;
                            }
                        }
                    } else {
                        for (Integer number : numbers) {
                            sum += number;

                        }
                    }
                    System.out.println(sum);
                    break;
            }
            line = scanner.nextLine();
        }
        for (Integer number : numbers) {
            if (number >= 0) {
                System.out.print(number + " ");
            }
        }
    }
}
