import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());

        double half = n * 0.5;

        int count = 0;
        while (n >= m) {
            count++;
            n -= m;
            if (y != 0 && n == half) {
                n /= y;
            }
        }
        System.out.println(n);
        System.out.println(count);
    }
}
