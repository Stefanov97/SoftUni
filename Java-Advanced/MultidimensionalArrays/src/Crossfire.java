import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = scanner.nextInt();
        int matrixCols = scanner.nextInt();
        scanner.nextLine();
        int start = 1;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int rows = 0; rows < matrixRows; rows++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int cols = 0; cols < matrixCols; cols++) {
                row.add(start++);
            }
            matrix.add(row);

        }
        String line = scanner.nextLine();
        while (!"Nuke it from orbit".equals(line)) {
            int[] tokens = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
            int currentRow = tokens[0];
            int currentCol = tokens[1];
            int radius = tokens[2];

            for (int rows = currentRow - radius; rows <= currentRow + radius; rows++) {
                if (isInBounds(matrix, rows, currentCol)) {
                    matrix.get(rows).set(currentCol, 0);
                }
            }
            for (int cols = currentCol - radius; cols <= currentCol + radius; cols++) {
                if (isInBounds(matrix, currentRow, cols)) {
                    matrix.get(currentRow).set(cols, 0);
                }
            }

            for (int rows = 0; rows < matrix.size(); rows++) {
                for (int cols = 0; cols < matrix.get(rows).size(); cols++) {
                    if (matrix.get(rows).get(cols) == 0) {
                        matrix.get(rows).remove(cols);
                        cols--;
                    }
                }
            }

            for (int rows = 0; rows < matrix.size(); rows++) {
                if (matrix.get(rows).isEmpty()) {
                    matrix.remove(rows);
                    rows--;
                }
            }
            line = scanner.nextLine();
        }
        printMatrix(matrix);
    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int rows, int currentCol) {
        return rows >= 0 && rows < matrix.size() && currentCol >= 0 && currentCol < matrix.get(rows).size();
    }


    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
