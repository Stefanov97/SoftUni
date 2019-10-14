import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedAreasInAMatrix {
    static int size;

    public static void main(String[] args) {
        class Area {
            private int startRow;
            private int startCol;
            private int size;

            public Area(int startRow, int startCol, int size) {
                this.startRow = startRow;
                this.startCol = startCol;
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public int getStartCol() {
                return startCol;
            }

            public int getSize() {
                return size;
            }


            public String toString(int number) {
                return String.format("Area #%d at (%d, %d), size: %d", number, this.startRow, this.startCol, this.size);
            }
        }
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        int numberOfCols = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[numberOfRows][numberOfCols];
        for (int rows = 0; rows < numberOfRows; rows++) {
            String line = scanner.nextLine().replaceAll("\\s+", "");
            for (int cols = 0; cols < numberOfCols; cols++) {
                matrix[rows][cols] = line.charAt(cols);

            }
        }
        List<Area> areas = new ArrayList<>();

        for (int rows = 0; rows < numberOfRows; rows++) {
            for (int cols = 0; cols < numberOfCols; cols++) {
                if (matrix[rows][cols] == '-') {
                    size = 0;
                    findAreaSize(matrix, rows, cols);
                    Area area = new Area(rows, cols, size);
                    areas.add(area);

                }
            }
        }
        System.out.println("Total areas found: " + areas.size());
        int number = 1;

        areas.sort((f, s) -> {
            int result = s.getSize() - f.getSize();
            if (result == 0) {
                result = f.startRow - s.startRow;

                if (result == 0) {
                    result = f.startCol - s.startCol;
                }
            }

            return result;
        });
        for (Area area : areas) {
            System.out.println(area.toString(number++));
        }
    }

    private static void findAreaSize(char[][] matrix, int rows, int cols) {

        if (!isInBounds(matrix, rows, cols) || matrix[rows][cols] == 'V' || matrix[rows][cols] == '*') {
            return;
        }
        size++;
        matrix[rows][cols] = 'V';
        findAreaSize(matrix, rows - 1, cols);
        findAreaSize(matrix, rows + 1, cols);
        findAreaSize(matrix, rows, cols + 1);
        findAreaSize(matrix, rows, cols - 1);


    }
    private static boolean isInBounds(char[][] matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[rows].length;
    }
}
