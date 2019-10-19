import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String patternType = input[1];
        int[][] matrix = new int[size][size];
        if (patternType.equals("A")) {
            int value = 1;
            for (int cols = 0; cols < size; cols++) {
                for (int rows = 0; rows < size; rows++) {
                    matrix[rows][cols] = value++;
                }
            }
        } else {
            int value = 1;
            for (int cols = 0; cols < size; cols++) {
                if (cols % 2 == 0) {
                    for (int rows = 0; rows < size; rows++) {
                        matrix[rows][cols] = value++;
                    }
                } else {
                    for (int rows = size - 1; rows >= 0; rows--) {
                        matrix[rows][cols] = value++;
                    }
                }
            }
        }
        for (int rows = 0; rows < size; rows++) {
            for (int cols = 0; cols < size; cols++) {
                System.out.print(matrix[rows][cols] + " ");
            }
            System.out.println();
        }
    }
}
