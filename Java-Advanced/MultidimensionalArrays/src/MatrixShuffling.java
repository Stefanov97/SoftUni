import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialRows = scanner.nextInt();
        int initialCols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[initialRows][initialCols];
        for (int rows = 0; rows < initialRows; rows++) {
            String[] input = scanner.nextLine().split("\\s");
            for (int cols = 0; cols < initialCols; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length != 5 || !tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
            } else {
                int firstRow = Integer.parseInt(tokens[1]);
                int firstCol = Integer.parseInt(tokens[2]);
                int secondRow = Integer.parseInt(tokens[3]);
                int secondCol = Integer.parseInt(tokens[4]);
                if (areValidCoordinates(matrix, firstCol, firstRow, secondCol, secondRow)) {
                    String temp = matrix[firstRow][firstCol];
                    matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                    matrix[secondRow][secondCol] = temp;
                    printMatrix(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            }
            input = scanner.nextLine();
        }
    }

    private static boolean areValidCoordinates(String[][] matrix, int firstCol, int firstRow, int secondCol, int secondRow) {
        return firstRow >= 0 && firstRow < matrix.length && firstCol >= 0 && firstCol < matrix[firstRow].length &&
                secondRow >= 0 && secondRow < matrix.length && secondCol >= 0 && secondCol < matrix[secondRow].length;

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
