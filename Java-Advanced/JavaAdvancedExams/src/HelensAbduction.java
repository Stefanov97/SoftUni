import java.util.ArrayDeque;
import java.util.Scanner;

public class HelensAbduction {
    static void printMatrix(String[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerEnergy = Integer.parseInt(scanner.nextLine());
        int numberOfRows = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[numberOfRows][];
        int playerRow = 0;
        int playerCol = 0;
        int helenRow = 0;
        int helenCol = 0;

        for (int rows = 0; rows < numberOfRows; rows++) {
            String inputRow = scanner.nextLine();
            field[rows] = new String[inputRow.length()];
            for (int cols = 0; cols < inputRow.length(); cols++) {
                field[rows][cols] = String.valueOf(inputRow.charAt(cols));
                if (inputRow.charAt(cols) == 'P') {
                    playerCol = cols;
                    playerRow = rows;
                }
                if (inputRow.charAt(cols) == 'H') {
                    helenCol = cols;
                    helenRow = rows;
                }
            }
        }
        boolean isRescued = false;
        while (playerEnergy > 0) {
            playerEnergy--;
            String[] tokens = scanner.nextLine().split("\\s+");
            String direction = tokens[0];
            int enemyRow = Integer.parseInt(tokens[1]);
            int enemyCol = Integer.parseInt(tokens[2]);
            field[enemyRow][enemyCol] = "S";


            switch (direction) {
                case "up":
                    if (playerRow - 1 >= 0) {
                        field[playerRow][playerCol] = "-";
                        if (field[playerRow - 1][playerCol].equals("S")) {
                            playerEnergy -= 2;
                            field[playerRow - 1][playerCol] = "P";
                            playerRow = playerRow - 1;
                        } else if (field[playerRow - 1][playerCol].equals("H")) {
                            field[playerRow - 1][playerCol] = "-";
                            isRescued = true;
                        } else {
                            field[playerRow - 1][playerCol] = "P";
                            playerRow = playerRow - 1;
                        }
                    }

                    break;
                case "down":
                    if (playerRow + 1 < field.length) {
                        field[playerRow][playerCol] = "-";
                        if (field[playerRow + 1][playerCol].equals("S")) {
                            playerEnergy -= 2;
                            field[playerRow + 1][playerCol] = "P";
                            playerRow = playerRow + 1;
                        } else if (field[playerRow + 1][playerCol].equals("H")) {
                            field[playerRow + 1][playerCol] = "-";
                            isRescued = true;
                        } else {
                            field[playerRow + 1][playerCol] = "P";
                            playerRow = playerRow + 1;
                        }
                    }
                    break;
                case "left":
                    if (playerCol - 1 >= 0) {
                        field[playerRow][playerCol] = "-";
                        if (field[playerRow][playerCol - 1].equals("S")) {
                            playerEnergy -= 2;
                            field[playerRow][playerCol - 1] = "P";
                            playerCol = playerCol - 1;
                        } else if (field[playerRow][playerCol - 1].equals("H")) {
                            field[playerRow][playerCol - 1] = "-";
                            isRescued = true;
                        } else {
                            field[playerRow][playerCol - 1] = "P";
                            playerCol = playerCol - 1;
                        }
                    }
                    break;
                case "right":
                    if (playerCol + 1 < field[playerRow].length) {
                        field[playerRow][playerCol] = "-";
                        if (field[playerRow][playerCol + 1].equals("S")) {
                            playerEnergy -= 2;
                            field[playerRow][playerCol + 1] = "P";
                            playerCol = playerCol + 1;
                        } else if (field[playerRow][playerCol + 1].equals("H")) {
                            field[playerRow][playerCol + 1] = "-";
                            isRescued = true;
                        } else {
                            field[playerRow][playerCol + 1] = "P";
                            playerCol = playerCol + 1;
                        }
                    }
                    break;
            }
            if (isRescued) {
                break;
            }
            if (playerEnergy <= 0) {
                field[playerRow][playerCol] = "X";
            }
        }
        if (!isRescued) {
            System.out.println(String.format("Paris died at %d;%d.", playerRow, playerCol));

        } else {
            System.out.println(String.format("Paris has successfully abducted Helen! Energy left: %d", playerEnergy));
        }
        printMatrix(field);
    }
}
