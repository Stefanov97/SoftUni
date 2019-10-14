import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int matrixRows = Integer.parseInt(dimensions[0]);
        int matrixCols = Integer.parseInt(dimensions[1]);
        char[][] matrix = new char[matrixRows][matrixCols];
        for (int rows = 0; rows < matrixRows; rows++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int cols = 0; cols < matrixCols; cols++) {
                matrix[rows][cols] = line.charAt(cols);
            }
        }

        char symbolToFill = scanner.nextLine().charAt(0);
        String[] indexes = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(indexes[0]);
        int startCol = Integer.parseInt(indexes[1]);

        char symbolToStartWith = matrix[startRow][startCol];

        fillTheMatrix(matrix, symbolToFill, startRow, startCol, symbolToStartWith);

        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static void fillTheMatrix(char[][] matrix, char symbolToFill, int row, int col, char symbolToStartWith) {
        if (!isInBounds(matrix, row, col) || symbolToFill == symbolToStartWith || matrix[row][col] != symbolToStartWith) {
            return;
        }
        matrix[row][col] = symbolToFill;
        fillTheMatrix(matrix, symbolToFill, row - 1, col, symbolToStartWith);
        fillTheMatrix(matrix, symbolToFill, row + 1, col, symbolToStartWith);
        fillTheMatrix(matrix, symbolToFill, row, col + 1, symbolToStartWith);
        fillTheMatrix(matrix, symbolToFill, row, col - 1, symbolToStartWith);

    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
