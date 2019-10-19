import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        int sum = 0;

        for (int i = 0; i < matrixRows; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < numbers.length; j++) {
                int number = numbers[j];
                sum += number;
            }
        }
        System.out.println(matrixRows);
        System.out.println(matrixCols);
        System.out.println(sum);
    }
}
