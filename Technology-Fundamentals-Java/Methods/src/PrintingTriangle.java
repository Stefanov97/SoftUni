import java.util.Scanner;

public class PrintingTriangle {


    static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            printLine(1, i);
        }
        for (int i = input - 1; i >= 1; i--) {
            printLine(1, i);
        }

    }

}

