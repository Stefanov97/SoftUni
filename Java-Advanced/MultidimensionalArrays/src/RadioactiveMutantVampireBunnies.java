import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    static boolean isEscaped = false;
    static boolean isDead = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = scanner.nextInt();
        int matrixCols = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[matrixRows][matrixCols];
        int countPlayers = 0;
        int playerRow = 0;
        int playerCol = 0;

        for (int rows = 0; rows < matrixRows; rows++) {
            char[] input = scanner.nextLine().toCharArray();
            for (int cols = 0; cols < matrixCols; cols++) {
                if (input[cols] == 'P') {
                    if (countPlayers < 1) {
                        matrix[rows][cols] = input[cols];
                        playerCol = cols;
                        playerRow = rows;
                        countPlayers++;
                    }
                }
                if (input[cols] == 'B' || input[cols] == '.') {

                    matrix[rows][cols] = input[cols];
                }
            }
        }
        char[] input = scanner.nextLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            List<Integer> bunniesPositions = new ArrayList<>();
            for (int r = 0; r < matrixRows; r++) {
                for (int c = 0; c < matrixCols; c++) {
                    if (matrix[r][c] == 'B') {
                        bunniesPositions.add(r);
                        bunniesPositions.add(c);
                    }
                }
            }
            char command = input[i];

            switch (command) {
                case 'U':
                    matrix = goUp(matrix, playerRow, playerCol);
                    playerRow--;
                    break;
                case 'D':
                    matrix = goDown(matrix, playerRow, playerCol);
                    playerRow++;
                    break;
                case 'R':
                    matrix = goRight(matrix, playerRow, playerCol);
                    playerCol++;
                    break;
                case 'L':
                    matrix = goLeft(matrix, playerRow, playerCol);
                    playerCol--;
                    break;
            }
            if (isDead) {
                matrix = spreadBunnies(matrix, bunniesPositions);
                break;
            }
            if (playerRow < 0 || playerRow >= matrixRows || playerCol < 0 || playerCol >= matrixCols) {
                matrix = spreadBunnies(matrix, bunniesPositions);
                isEscaped = true;
                break;
            }
            matrix = spreadBunnies(matrix, bunniesPositions);
            if (isDead) {
                break;
            }
        }
        printMatrix(matrix);
        if (isEscaped) {
            if (playerCol < 0) {
                playerCol = 0;
            }
            if (playerCol >= matrixCols) {
                playerCol = matrixCols - 1;
            }
            if (playerRow < 0) {
                playerRow = 0;
            }
            if (playerRow >= matrixRows) {
                playerRow = matrixRows - 1;
            }
            System.out.printf("won: %d %d", playerRow, playerCol).println();
        } else if (isDead) {
            System.out.printf("dead: %d %d", playerRow, playerCol).println();
        }
    }
    private static char[][] spreadBunnies(char[][] matrix, List<Integer> bunniesPositions) {
        for (int i = 0; i < bunniesPositions.size(); i += 2) {
            int bunnyRow = bunniesPositions.get(i);
            int bunnyCol = bunniesPositions.get(i + 1);
            if (bunnyRow - 1 >= 0) {
                if (matrix[bunnyRow - 1][bunnyCol] == '.') {
                    matrix[bunnyRow - 1][bunnyCol] = 'B';
                } else if (matrix[bunnyRow - 1][bunnyCol] == 'P') {
                    matrix[bunnyRow - 1][bunnyCol] = 'B';
                    isDead = true;

                } else {
                    matrix[bunnyRow - 1][bunnyCol] = 'B';
                }
            }
            if (bunnyRow + 1 < matrix.length) {
                if (matrix[bunnyRow + 1][bunnyCol] == '.') {
                    matrix[bunnyRow + 1][bunnyCol] = 'B';
                } else if (matrix[bunnyRow + 1][bunnyCol] == 'P') {
                    matrix[bunnyRow + 1][bunnyCol] = 'B';
                    isDead = true;
                } else {
                    matrix[bunnyRow + 1][bunnyCol] = 'B';
                }
            }
            if (bunnyCol + 1 < matrix[0].length) {
                if (matrix[bunnyRow][bunnyCol + 1] == '.') {
                    matrix[bunnyRow][bunnyCol + 1] = 'B';
                } else if (matrix[bunnyRow][bunnyCol + 1] == 'P') {
                    matrix[bunnyRow][bunnyCol + 1] = 'B';
                    isDead = true;
                } else {
                    matrix[bunnyRow][bunnyCol + 1] = 'B';
                }
            }
            if (bunnyCol - 1 >= 0) {
                if (matrix[bunnyRow][bunnyCol - 1] == '.') {
                    matrix[bunnyRow][bunnyCol - 1] = 'B';
                } else if (matrix[bunnyRow][bunnyCol - 1] == 'P') {
                    matrix[bunnyRow][bunnyCol - 1] = 'B';
                    isDead = true;
                } else {
                    matrix[bunnyRow][bunnyCol - 1] = 'B';
                }
            }
        }
        return matrix;
    }
    private static char[][] goLeft(char[][] matrix, int playerRow, int playerCol) {
        matrix[playerRow][playerCol] = '.';
        if (playerCol - 1 >= 0) {
            playerCol -= 1;
            if (matrix[playerRow][playerCol] != 'B') {
                matrix[playerRow][playerCol] = 'P';
            } else {
                matrix[playerRow][playerCol] = 'B';
                isDead = true;
            }
        }
        return matrix;
    }
    private static char[][] goRight(char[][] matrix, int playerRow, int playerCol) {
        matrix[playerRow][playerCol] = '.';
        if (playerCol + 1 < matrix[playerRow].length) {
            playerCol += 1;
            if (matrix[playerRow][playerCol] != 'B') {
                matrix[playerRow][playerCol] = 'P';
            } else {
                matrix[playerRow][playerCol] = 'B';
                isDead = true;
            }
        }
        return matrix;
    }
    private static char[][] goDown(char[][] matrix, int playerRow, int playerCol) {
        matrix[playerRow][playerCol] = '.';
        if (playerRow + 1 < matrix.length) {
            playerRow += 1;
            if (matrix[playerRow][playerCol] != 'B') {
                matrix[playerRow][playerCol] = 'P';
            } else {
                matrix[playerRow][playerCol] = 'B';
                isDead = true;
            }
        }
        return matrix;
    }
    private static char[][] goUp(char[][] matrix, int playerRow, int playerCol) {
        matrix[playerRow][playerCol] = '.';
        if (playerRow - 1 >= 0) {
            playerRow -= 1;
            if (matrix[playerRow][playerCol] != 'B') {
                matrix[playerRow][playerCol] = 'P';
            } else {
                matrix[playerRow][playerCol] = 'B';
                isDead = true;
            }
        }
        return matrix;
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