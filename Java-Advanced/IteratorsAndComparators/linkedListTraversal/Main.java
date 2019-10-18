import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList list = new MyLinkedList();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add":
                    list.add(number);
                    break;
                case "Remove":
                    list.remove(number);
                    break;
            }
        }
        System.out.println(list.getSize());
        list.forEach(e -> System.out.print(e + " "));
    }
}
