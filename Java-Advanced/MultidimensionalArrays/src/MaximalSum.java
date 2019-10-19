import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialRows = scanner.nextInt();
        int initialCols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[initialRows][initialCols];
        for (int rows = 0; rows < initialRows; rows++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < initialCols; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;
        for (int rows = 0; rows < initialRows; rows++) {
            for (int cols = 0; cols < initialCols; cols++) {
                if (cols + 2 < matrix[rows].length && rows + 2 < matrix.length) {
                    int currentSum = findSum(rows, cols, matrix);
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                        maxRow = rows;
                        maxCol = cols;
                    }
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int rows = maxRow; rows <= maxRow + 2; rows++) {
            for (int cols = maxCol; cols <= maxCol + 2; cols++) {
                System.out.print(matrix[rows][cols] + " ");

            }
            System.out.println();

        }
    }

    private static int findSum(int r, int c, int[][] matrix) {
        int currentSum = 0;

        int element = matrix[r][c];
        int secondElement = matrix[r][c + 1];
        int thirdElement = matrix[r][c + 2];
        int fourthElement = matrix[r + 1][c];
        int fifthElement = matrix[r + 1][c + 1];
        int sixthhElement = matrix[r + 1][c + 2];
        int seventhElement = matrix[r + 2][c];
        int eightElement = matrix[r + 2][c + 1];
        int ninghtElement = matrix[r + 2][c + 2];

        return currentSum += element + secondElement + thirdElement + fourthElement + fifthElement + sixthhElement + seventhElement + eightElement + ninghtElement;
    }
}
