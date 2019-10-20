import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<String> outputQueue = new ArrayDeque<>();
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            String element = input[i];
            if (Character.isLetterOrDigit(element.charAt(0))) {
                outputQueue.offer(element);
            } else {
                if (stack.isEmpty()) {
                    stack.push(element);
                } else {
                    String lastOperator = stack.peek();
                    switch (element) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                stack.push(element);
                            } else {
                                outputQueue.offer(stack.pop());
                                stack.push(element);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                outputQueue.offer(stack.pop());
                                stack.push(element);
                            } else {
                                stack.push(element);
                            }
                            break;
                        case "(":
                            stack.push(element);
                            break;
                        case ")":
                            while (!stack.peek().equals("(")) {
                                outputQueue.offer(stack.pop());
                            }
                            //Removing the non-necessary open parenthesis '('
                            stack.pop();
                            break;
                    }
                }
            }
        }

        while (!outputQueue.isEmpty()) {
            System.out.print(outputQueue.poll() + " ");
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}