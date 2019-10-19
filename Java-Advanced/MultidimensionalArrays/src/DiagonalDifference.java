import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[size][size];

        for (int rows = 0; rows < size; rows++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < size; cols++) {
                matrix[rows][cols] = input[cols];
            }

        }
        int firstSum = findFirstDiagonalSum(matrix, size);
        int secondSum = findSecondDiagonalSum(matrix, size);
        System.out.println(Math.abs(firstSum - secondSum));
    }

    private static int findSecondDiagonalSum(int[][] matrix, int size) {
        int secondSum = 0;
        for (int rows = size - 1; rows >= 0; rows--) {
            for (int cols = 0; cols < size; cols++) {
                secondSum += matrix[rows - cols][cols];

            }
            break;
        }
        return secondSum;
    }

    private static int findFirstDiagonalSum(int[][] matrix, int size) {
        int firstSum = 0;
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                if (rows == cols) {
                    firstSum += matrix[rows][cols];
                }
            }
        }
        return firstSum;
    }
}
