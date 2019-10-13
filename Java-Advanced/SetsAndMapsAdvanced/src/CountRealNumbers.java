import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> result = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToDouble(Double::parseDouble).toArray();

        for (int i = 0; i < input.length; i++) {
            double key = input[i];
            result.putIfAbsent(key, 0);
            result.put(key, result.get(key) + 1);
        }
        result.entrySet().stream().forEach((number) -> {
            System.out.printf("%.1f -> %d", number.getKey(), number.getValue()).println();
        });
    }
}
