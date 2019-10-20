import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }
        while (stack.size() > 2) {
            int first = Integer.parseInt(stack.pop());
            String comparator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            if (comparator.equals("-")) {
                stack.push(first - second + "");
            } else {
                stack.push(first + second + "");
            }
        }

        System.out.println(stack.peek());
    }
}
