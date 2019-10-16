import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] nums = Arrays.stream(reader.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        UnaryOperator<Double> addVAT = x -> x * 1.20;
        System.out.println("Prices with VAT:");
        Arrays.stream(nums).map(number -> addVAT.apply(number)).forEach(n -> System.out.printf("%.2f%n", n));

    }
}
