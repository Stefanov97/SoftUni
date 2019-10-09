import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = Long.parseLong(scanner.nextLine());

        printTribonacciSequence(num);
    }

    static void printTribonacciSequence(long num) {
        int a = 1, b = 1, c = 2, d = 0;
        if (num == 1) {
            System.out.print(a);
        } else if (num == 2) {
            System.out.print(a + " " + b);
        } else {
            System.out.print(a + " " + b + " " + c + " ");
        }
        for (int i = 4; i <= num; i++) {
            d = a + b + c;
            System.out.print(d + " ");
            a = b;
            b = c;
            c = d;
        }
    }
}
