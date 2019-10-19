import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int firstMatrixRows = Integer.parseInt(input[0]);
        int firstMatrixCols = Integer.parseInt(input[1]);

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        for (int rows = 0; rows < firstMatrixRows; rows++) {
            String[] inputNumbers = scanner.nextLine().split("\\s+");

            for (int cols = 0; cols < inputNumbers.length; cols++) {
                firstMatrix[rows][cols] = Integer.parseInt(inputNumbers[cols]);
            }
        }
        String[] secondInput = scanner.nextLine().split("\\s+");
        int secondMatrixRows = Integer.parseInt(secondInput[0]);
        int secondMatrixCols = Integer.parseInt(secondInput[1]);

        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];

        for (int rows = 0; rows < secondMatrixRows; rows++) {
            String[] secondInputNumbers = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < secondInputNumbers.length; cols++) {
                secondMatrix[rows][cols] = Integer.parseInt(secondInputNumbers[cols]);
            }
        }
        boolean areEqual = true;
        if (firstMatrixRows != secondMatrixRows || firstMatrixCols != secondMatrixCols) {
            System.out.println("not equal");
            return;
        }
        for (int i = 0; i < firstMatrixRows; i++) {
            for (int j = 0; j < firstMatrixCols; j++) {
                int firstValue = firstMatrix[i][j];
                int secondValue = secondMatrix[i][j];
                if (firstValue != secondValue) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        if (areEqual) {
            System.out.println("equal");
        }
    }
}
