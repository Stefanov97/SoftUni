import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        int[][] mainMatrix = new int[matrixRows][matrixCols];
        int maxSum = Integer.MIN_VALUE;
        int maxRows = 0;
        int maxCols = 0;
        for (int rows = 0; rows < matrixRows; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < numbers.length; cols++) {
                mainMatrix[rows][cols] = numbers[cols];
            }
        }
        int[][] maxSubMatrix = new int[2][2];
        for (int rows = 0; rows < matrixRows - 1; rows++) {
            for (int cols = 0; cols < mainMatrix[rows].length - 1; cols++) {
                int currentSum = getSum(rows, cols, mainMatrix);
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxCols = cols;
                    maxRows = rows;
                    maxSubMatrix[0][0] = mainMatrix[maxRows][maxCols];
                    maxSubMatrix[0][1] = mainMatrix[maxRows][maxCols + 1];
                    maxSubMatrix[1][0] = mainMatrix[maxRows + 1][maxCols];
                    maxSubMatrix[1][1] = mainMatrix[maxRows + 1][maxCols + 1];
                }
            }
        }
        System.out.println(maxSubMatrix[0][0] + " " + maxSubMatrix[0][1]);
        System.out.println(maxSubMatrix[1][0] + " " + maxSubMatrix[1][1]);
        System.out.println(maxSum);
    }
    private static int getSum(int rows, int cows, int[][] mainMatrix) {
        return mainMatrix[rows][cows] + mainMatrix[rows][cows + 1] + mainMatrix[rows + 1][cows] + mainMatrix[rows + 1][cows + 1];
    }

}
