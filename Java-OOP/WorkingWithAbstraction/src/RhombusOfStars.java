import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        drawFirstPartRhombus(n);
        drawSecondPartRhombus(n);

    }

    private static void drawSecondPartRhombus(int n) {
        for (int i = n - 1; i > 0; i--) {
            printSpaces("", n - i);
            printRow(i);
        }
    }

    private static void printRow(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    private static void drawFirstPartRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            printSpaces("", n - i);
            printRow(i);
        }
    }

    private static void printSpaces(String spaces, int numberOfSpaces) {
        for (int j = 0; j < numberOfSpaces; j++) {
            spaces += " ";
        }
        System.out.print(spaces);
    }
}
