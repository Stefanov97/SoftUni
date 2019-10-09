import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            String[] commands = line.split(" +");
            String toDo = commands[0];

            switch (toDo) {
                case "Add":
                    numbers.add(Integer.valueOf(commands[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, Integer.valueOf(commands[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(commands[2]);
                    if (commands[1].equals("left")) {

                        while (count-- > 0) {
                            numbers.add(numbers.get(0));
                            numbers.remove(0);
                        }
                    } else {
                        while (count-- > 0) {
                            numbers.add(0, numbers.get(numbers.size() - 1));
                            numbers.remove(numbers.size() - 1);
                        }
                    }

                    break;


            }
            line = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
