import java.util.Scanner;

public class CharactersInRange {
    static void printCharactersInRange(char a, char b) {
        int begin = 0;
        int end = 0;
        if ((int) a < (int) b) {
            begin = a;
            end = b;
        } else {
            begin = b;
            end = a;
        }
        for (int i = begin + 1; i < end; i++) {
            System.out.print((char) i + " ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);

        printCharactersInRange(a, b);

    }
}
