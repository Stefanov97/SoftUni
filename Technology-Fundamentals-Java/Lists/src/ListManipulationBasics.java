import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();


        while (!"end".equals(input)) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Add":
                    list.add(Integer.parseInt(command[1]));
                    break;
                case "Remove":
                    list.remove(Integer.valueOf(command[1]))
                    ;
                    break;
                case "RemoveAt":
                    list.remove(Integer.parseInt(command[1]));
                    break;
                case "Insert":
                    list.add(Integer.parseInt(command[2]), Integer.parseInt(command[1]));
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer number : list) {
            System.out.print(number + " ");
        }

    }
}
