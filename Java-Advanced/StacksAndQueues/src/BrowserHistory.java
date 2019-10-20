import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!"Home".equals(input)) {
            switch (input) {
                case "back":
                    if (stack.size() > 1) {
                        stack.pop();
                        System.out.println(stack.peek());
                    } else {
                        System.out.println("no previous URLs");
                    }
                    break;
                default:
                    stack.push(input);
                    System.out.println(stack.peek());
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
