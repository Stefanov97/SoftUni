import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int matrixRows = dimensions[0];
        int matrixCols = dimensions[1];

        int[][] matrix = new int[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            int[] numbersForRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < numbersForRow.length; cols++) {
                matrix[rows][cols] = numbersForRow[cols];
            }
        }

        int lookForNumber = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                int currentNumber = matrix[rows][cols];
                if (currentNumber == lookForNumber) {
                    isFound = true;
                    System.out.println(rows + " " + cols);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
