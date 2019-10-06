import java.math.BigDecimal;
import java.util.Scanner;

public class BigDecimalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        java.math.BigDecimal sum = new java.math.BigDecimal(0);
        for (int i = 0; i < n; i++) {
            java.math.BigDecimal number = new java.math.BigDecimal(scanner.nextLine());
            sum = sum.add(number);
        }
        System.out.println(sum);
    }
}
