import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int opening = 0;
        int closing = 0;
        boolean isBalanced = true;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (i == 0 && input.equalsIgnoreCase(")")) {
                isBalanced = false;
                break;
            }
            if (input.equalsIgnoreCase("(")) {
                opening++;
            } else if (input.equalsIgnoreCase(")")) {
                closing++;
            }
            if (opening >= closing + 2 || closing >= opening + 1) {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced && opening == closing) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }

}
