import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int d = Integer.parseInt(scanner.nextLine());
        int[] firstPair = new int[]{Math.abs(a) + Math.abs(b)};
        int[] secondPair = new int[]{Math.abs(c) + Math.abs(d)};
        printClosestPointToTheCenter(firstPair, secondPair, a, b, c, d);


    }

    private static void printClosestPointToTheCenter(int[] firstPair, int[] secondPair, int a, int b, int c, int d) {
        if (firstPair[0] <= secondPair[0]) {

            System.out.printf("(%d, %d)", a, b);
        } else {
            System.out.printf("(%d, %d)", c, d);
        }
    }
}
