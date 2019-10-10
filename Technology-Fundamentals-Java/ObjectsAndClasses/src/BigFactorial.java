import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigInteger factorial = new BigInteger("1");


        for (int j = 1; j <= n; j++) {
            String number = String.valueOf(j);
            BigInteger numForMult = new BigInteger(number);
            factorial = factorial.multiply(numForMult);

        }

        System.out.println(factorial);

    }
}
