import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixRows = Integer.parseInt(scanner.nextLine());
        int matrixCols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[matrixRows][matrixCols];
        char[][] secondMatrix = new char[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < input.length; cols++) {
                firstMatrix[rows][cols] = input[cols].charAt(0);
            }
        }
        for (int rows = 0; rows < matrixRows; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < input.length; cols++) {
                secondMatrix[rows][cols] = input[cols].charAt(0);
            }
        }
        char[][] result = new char[matrixRows][matrixCols];

        for (int rows = 0; rows < matrixRows; rows++) {
            for (int cols = 0; cols < matrixCols; cols++) {
                char firstValue = firstMatrix[rows][cols];
                char secondValue = secondMatrix[rows][cols];
                if (firstValue == secondValue) {
                    result[rows][cols] = firstValue;
                } else {
                    result[rows][cols] = '*';
                }
            }
        }
        for (char[] chars : result) {
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i] + " ");
            }
            System.out.println();
        }
    }
}
