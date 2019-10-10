import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            boolean isInteger = true;
            try {
                int integer = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                isInteger = false;
            }
            boolean isDouble = true;
            try {
                double floating = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                isDouble = false;
            }

            if (isInteger) {
                System.out.printf("%s is integer type", input).println();
            } else if (isDouble) {
                System.out.printf("%s is floating point type", input).println();
            } else if (input.equalsIgnoreCase("true") || "false".equalsIgnoreCase(input)) {
                System.out.printf("%s is boolean type", input).println();
            } else if (input.length() == 1) {
                System.out.printf("%s is character type", input).println();
            } else {
                System.out.printf("%s is string type", input).println();
            }

            input = scanner.nextLine();
        }
    }
}
