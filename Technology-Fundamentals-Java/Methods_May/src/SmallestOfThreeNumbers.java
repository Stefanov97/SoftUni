import java.util.Scanner;

public class SmallestOfThreeNumbers {
    static int getSmallest(int a, int b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int x = getSmallest(a, b);
        int result = getSmallest(x, c);
        System.out.println(result);
    }
}
