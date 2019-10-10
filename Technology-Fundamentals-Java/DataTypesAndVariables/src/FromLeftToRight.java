import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            long[] input = Arrays.stream(scanner.nextLine().split(" +")).mapToLong(Long::parseLong).toArray();
            long biggest = 0;
            int sum = 0;
            if (input[0] > input[1]) {
                biggest = input[0];
            } else {
                biggest = input[1];
            }
            String big = String.valueOf(biggest);
            for (int j = 0; j < big.length(); j++) {
                if (big.charAt(j) != '-') {
                    sum += Integer.parseInt(String.valueOf(big.charAt(j)));
                }
            }
            System.out.println(sum);
        }
    }
}
