import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String initialText = "";
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(initialText);

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "1":
                    String text = tokens[1];
                    initialText += text;
                    stack.push(initialText);
                    break;
                case "2":
                    int count = Integer.parseInt(tokens[1]);
                    initialText = initialText.substring(0, initialText.length() - count);
                    stack.push(initialText);

                    break;
                case "3":
                    int index = Integer.parseInt(tokens[1]);
                    System.out.println(initialText.charAt(index - 1));

                    break;
                case "4":
                    stack.pop();
                    initialText = stack.peek();
                    break;
            }
        }
    }
}
