import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        String line = scanner.nextLine();

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Push":

                    List<Integer> numbers = new ArrayList<>();
                    for (int i = 1; i < tokens.length; i++) {
                        String token = tokens[i];
                        numbers.add(Integer.parseInt(token.replace(",", "")));
                    }
                    for (int number : numbers) {
                        stack.push(number);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();

                    } catch (NullPointerException exp) {
                        System.out.println(exp.getMessage());
                    }
                    break;
            }

            line = scanner.nextLine();
        }

        for (Integer number : stack) {
            System.out.println(number);
        }
        for (Integer number : stack) {
            System.out.println(number);
        }
    }
}
