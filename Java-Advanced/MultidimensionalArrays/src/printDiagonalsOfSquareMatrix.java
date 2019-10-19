import java.util.Arrays;
import java.util.Scanner;

public class printDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int rows = 0; rows < size; rows++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int cols = 0; cols < numbers.length; cols++) {
                matrix[rows][cols] = numbers[cols];
            }
        }
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                if (rows == cols) {
                    System.out.print(matrix[rows][cols] + " ");
                }
            }
        }
        System.out.println();
        int cols = 0;
        for (int lastRow = size - 1; lastRow >= 0; lastRow--) {
            System.out.print(matrix[lastRow][cols++] + " ");

        }
    }
}
