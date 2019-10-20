import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            switch (input) {
                case "back":
                    if (stack.size() > 1) {
                        queue.push(stack.pop());
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                case "forward":
                    if (queue.isEmpty()) {
                        System.out.println("no next URLs");
                    } else {
                        stack.push(queue.peek());
                        System.out.println(queue.pop());
                    }
                    break;
                default:
                    stack.push(input);
                    System.out.println(stack.peek());
                    queue.clear();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
