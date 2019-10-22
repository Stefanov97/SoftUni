import java.util.Scanner;

public class TronRacers {
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

        int matrixCapacity = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[matrixCapacity][matrixCapacity];
        int firstPlayerRow = 0;
        int firstPlayerCol = 0;
        int secondPlayerRow = 0;
        int secondPlayerCol = 0;

        for (int rows = 0; rows < matrixCapacity; rows++) {
            String currentRow = scanner.nextLine();
            for (int cols = 0; cols < currentRow.length(); cols++) {
                if ((currentRow.charAt(cols) + "").equals("f")) {
                    firstPlayerRow = rows;
                    firstPlayerCol = cols;
                } else if ((currentRow.charAt(cols) + "").equals("s")) {
                    secondPlayerRow = rows;
                    secondPlayerCol = cols;
                }
                matrix[rows][cols] = String.valueOf(currentRow.charAt(cols));

            }
        }

        boolean areBothAlive = true;
        while (areBothAlive) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstCommand = tokens[0];
            String secondCommand = tokens[1];
            switch (firstCommand) {
                case "up":
                    if (firstPlayerRow - 1 < 0) {
                        firstPlayerRow = matrixCapacity;
                    }
                    if (matrix[firstPlayerRow - 1][firstPlayerCol].equals("s")) {
                        matrix[firstPlayerRow - 1][firstPlayerCol] = "x";
                        areBothAlive = false;
                    } else {
                        matrix[firstPlayerRow - 1][firstPlayerCol] = "f";
                        firstPlayerRow = firstPlayerRow - 1;
                    }
                    break;
                case "down":
                    if (firstPlayerRow + 1 >= matrixCapacity) {
                        firstPlayerRow = -1;
                    }
                    if (matrix[firstPlayerRow + 1][firstPlayerCol].equals("s")) {
                        matrix[firstPlayerRow + 1][firstPlayerCol] = "x";
                        areBothAlive = false;
                    } else {
                        matrix[firstPlayerRow + 1][firstPlayerCol] = "f";
                        firstPlayerRow = firstPlayerRow + 1;
                    }
                    break;
                case "right":
                    if (firstPlayerCol + 1 >= matrixCapacity) {
                        firstPlayerCol = -1;
                    }
                    if (matrix[firstPlayerRow][firstPlayerCol + 1].equals("s")) {
                        matrix[firstPlayerRow][firstPlayerCol + 1] = "x";
                        areBothAlive = false;
                    } else {
                        matrix[firstPlayerRow][firstPlayerCol + 1] = "f";
                        firstPlayerCol = firstPlayerCol + 1;
                    }
                    break;
                case "left":
                    if (firstPlayerCol - 1 < 0) {
                        firstPlayerCol = matrixCapacity;
                    }
                    if (matrix[firstPlayerRow][firstPlayerCol - 1].equals("s")) {
                        matrix[firstPlayerRow][firstPlayerCol - 1] = "x";
                        areBothAlive = false;
                    } else {
                        matrix[firstPlayerRow][firstPlayerCol - 1] = "f";
                        firstPlayerCol = firstPlayerCol - 1;
                    }
                    break;
            }
            if (areBothAlive) {
                switch (secondCommand) {
                    case "up":
                        if (secondPlayerRow - 1 < 0) {
                            secondPlayerRow = matrixCapacity;
                        }
                        if (matrix[secondPlayerRow - 1][secondPlayerCol].equals("f")) {
                            matrix[secondPlayerRow - 1][secondPlayerCol] = "x";
                            areBothAlive = false;
                        } else {
                            matrix[secondPlayerRow - 1][secondPlayerCol] = "s";
                            secondPlayerRow = secondPlayerRow - 1;
                        }
                        break;
                    case "down":
                        if (secondPlayerRow + 1 >= matrixCapacity) {
                            secondPlayerRow = -1;
                        }
                        if (matrix[secondPlayerRow + 1][secondPlayerCol].equals("f")) {
                            matrix[secondPlayerRow + 1][secondPlayerCol] = "x";
                            areBothAlive = false;
                        } else {
                            matrix[secondPlayerRow + 1][secondPlayerCol] = "s";
                            secondPlayerRow = secondPlayerRow + 1;
                        }
                        break;
                    case "right":
                        if (secondPlayerCol + 1 >= matrixCapacity) {
                            secondPlayerCol = -1;
                        }
                        if (matrix[secondPlayerRow][secondPlayerCol + 1].equals("f")) {
                            matrix[secondPlayerRow][secondPlayerCol + 1] = "x";
                            areBothAlive = false;
                        } else {
                            matrix[secondPlayerRow][secondPlayerCol + 1] = "s";
                            secondPlayerCol = secondPlayerCol + 1;
                        }
                        break;
                    case "left":
                        if (secondPlayerCol - 1 < 0) {
                            secondPlayerCol = matrixCapacity;
                        }
                        if (matrix[secondPlayerRow][secondPlayerCol - 1].equals("f")) {
                            matrix[secondPlayerRow][secondPlayerCol - 1] = "x";
                            areBothAlive = false;
                        } else {
                            matrix[secondPlayerRow][secondPlayerCol - 1] = "s";
                            secondPlayerCol = secondPlayerCol - 1;
                        }
                        break;
                }
            }
        }
        printMatrix(matrix);
    }
}
