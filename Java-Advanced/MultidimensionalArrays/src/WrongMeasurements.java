import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialRows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[initialRows][];

        for (int rows = 0; rows < initialRows; rows++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[rows] = new int[input.length];
            for (int cols = 0; cols < input.length; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }
        int numberRow = scanner.nextInt();
        int numberCol = scanner.nextInt();
        scanner.nextLine();
        int target = matrix[numberRow][numberCol];
        List<Integer> positionsOfTarget = new ArrayList<>();
        for (int rows = 0; rows < initialRows; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                int currentNumber = matrix[rows][cols];
                if (currentNumber == target) {
                    positionsOfTarget.add(rows);
                    positionsOfTarget.add(cols);
                    matrix[rows][cols] = findTheRightValue(matrix, rows, cols, target, positionsOfTarget);
                }
            }

        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();

        }
    }

    private static int findTheRightValue(int[][] matrix, int rows, int cols, int target, List<Integer> positionsOfTarget) {
        int rightValue = 0;
        rightValue += findLeft(matrix, rows, cols, target, positionsOfTarget);
        rightValue += findRight(matrix, rows, cols, target, positionsOfTarget);
        rightValue += findUp(matrix, rows, cols, target, positionsOfTarget);
        rightValue += findDown(matrix, rows, cols, target, positionsOfTarget);

        return rightValue;
    }

    private static int findDown(int[][] matrix, int rows, int cols, int target, List<Integer> positionsOfTarget) {
        int down = 0;
        if (rows == matrix.length - 1) {
            return down;
        }
        for (int i = 0; i < positionsOfTarget.size(); i += 2) {
            int targetRow = positionsOfTarget.get(i);
            int targetCol = positionsOfTarget.get(i + 1);

            if (rows + 1 == targetRow && cols == targetCol) {
                return 0;
            }
        }
        down = matrix[rows + 1][cols];
        if (down == target) {
            return 0;
        }
        return down;
    }

    private static int findUp(int[][] matrix, int rows, int cols, int target, List<Integer> positionsOfTarget) {
        int up = 0;
        if (rows == 0) {
            return up;
        }
        for (int i = 0; i < positionsOfTarget.size(); i += 2) {
            int targetRow = positionsOfTarget.get(i);
            int targetCol = positionsOfTarget.get(i + 1);

            if (rows - 1 == targetRow && cols == targetCol) {
                return 0;
            }
        }
        up = matrix[rows - 1][cols];

        if (up == target) {
            return 0;
        }

        return up;
    }

    private static int findRight(int[][] matrix, int rows, int cols, int target, List<Integer> positionsOfTarget) {
        int right = 0;
        if (cols == matrix[rows].length - 1) {
            return right;
        }
        for (int i = 0; i < positionsOfTarget.size(); i += 2) {
            int targetRow = positionsOfTarget.get(i);
            int targetCol = positionsOfTarget.get(i + 1);

            if (rows == targetRow && cols + 1 == targetCol) {
                return 0;
            }
        }
        right = matrix[rows][cols + 1];
        if (right == target) {
            return 0;
        }

        return right;
    }

    private static int findLeft(int[][] matrix, int rows, int cols, int target, List<Integer> positionsOfTarget) {
        int left = 0;
        if (cols == 0) {
            return left;
        }
        for (int i = 0; i < positionsOfTarget.size(); i += 2) {
            int targetRow = positionsOfTarget.get(i);
            int targetCol = positionsOfTarget.get(i + 1);

            if (rows == targetRow && cols - 1 == targetCol) {
                return 0;
            }
        }
        left = matrix[rows][cols - 1];

        if (left == target) {
            return 0;
        }
        return left;
    }
}
