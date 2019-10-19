import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialRows = scanner.nextInt();
        int initialCols = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[initialRows][initialCols];
        char start = 'a';
        for (int rows = 0; rows < initialRows; rows++) {
            int value = 0;
            for (int cols = 0; cols < initialCols; cols++) {
                matrix[rows][cols] = start + "" + (char) (start + value++) + start;

            }
            start++;
        }
        for (int rows = 0; rows < initialRows; rows++) {
            for (int cols = 0; cols < initialCols; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
