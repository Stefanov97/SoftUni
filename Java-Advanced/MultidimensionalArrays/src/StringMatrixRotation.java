import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstInput);
        int rotationsCount = 0;
        while (matcher.find()) {
            rotationsCount = Integer.parseInt(matcher.group(1)) / 90;
        }
        String line = scanner.nextLine();
        List<String> allWords = new ArrayList<>();
        while (!"END".equals(line)) {
            allWords.add(line);
            line = scanner.nextLine();
        }
        int matrixCols = 0;
        int matrixRows = allWords.size();
        for (String word : allWords) {
            int currentLength = word.length();
            if (currentLength > matrixCols) {
                matrixCols = currentLength;
            }
        }
        char[][] matrix = new char[matrixRows][matrixCols];
        for (int rows = 0; rows < matrixRows; rows++) {
            char[] letters = allWords.get(rows).toCharArray();
            for (int cols = 0; cols < matrixCols; cols++) {
                if (cols > letters.length - 1) {
                    matrix[rows][cols] = ' ';
                } else {
                    matrix[rows][cols] = letters[cols];
                }
            }
        }
        int tempRows = 0;
        int tempCols = 0;
        if (rotationsCount % 2 != 0) {
            tempRows = matrixCols;
            tempCols = matrixRows;
        } else {
            tempRows = matrixRows;
            tempCols = matrixCols;
        }
        int rotations = rotationsCount % 4;
        char[][] tempMatrix = new char[tempRows][tempCols];

        switch (rotations) {
            case 0:
                for (int rows = 0; rows < tempRows; rows++) {
                    for (int cols = 0; cols < tempCols; cols++) {
                        tempMatrix[rows][cols] = matrix[rows][cols];
                    }
                }
                break;
            case 1: {
                int lastTempRow = matrixRows - 1;
                for (int rows = 0; rows < tempRows; rows++) {
                    for (int cols = 0; cols < tempCols; cols++) {
                        tempMatrix[rows][cols] = matrix[lastTempRow--][rows];
                    }
                    lastTempRow = matrixRows - 1;
                }
            }
            break;
            case 2: {
                int lastMatrixCol = matrixCols - 1;
                int lastMatrixRow = matrixRows - 1;
                for (int rows = 0; rows < tempRows; rows++) {
                    for (int cols = 0; cols < tempCols; cols++) {
                        tempMatrix[rows][cols] = matrix[lastMatrixRow][lastMatrixCol--];
                    }
                    lastMatrixCol = matrixCols - 1;
                    lastMatrixRow--;
                }
            }
            break;
            case 3:
                int lastTempRow = 0;
                int lastTempCol = matrixCols - 1;
                for (int rows = 0; rows < tempRows; rows++) {
                    for (int cols = 0; cols < tempCols; cols++) {
                        tempMatrix[rows][cols] = matrix[lastTempRow++][lastTempCol];
                    }
                    lastTempRow = 0;
                    lastTempCol--;
                }
                break;
        }
        printMatrix(tempMatrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
