import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpaceStationEstablishment {
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

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[matrixSize][matrixSize];
        List<Integer> blackHolesIndexes = new ArrayList<>();
        int stephenRow = 0;
        int stephenCol = 0;
        int firstHoleRow = -1;
        int firstHoleCol = -1;
        int secondHoleRow = -1;
        int secondHoleCol = -1;
        for (int rows = 0; rows < matrixSize; rows++) {
            String input = scanner.nextLine();
            for (int cols = 0; cols < input.length(); cols++) {
                if (String.valueOf(input.charAt(cols)).equals("S")) {
                    stephenRow = rows;
                    stephenCol = cols;
                } else if (String.valueOf(input.charAt(cols)).equals("O")) {
                    blackHolesIndexes.add(rows);
                    blackHolesIndexes.add(cols);
                }
                matrix[rows][cols] = String.valueOf(input.charAt(cols));
            }
        }

        if (!blackHolesIndexes.isEmpty()) {
            firstHoleRow = blackHolesIndexes.get(0);
            firstHoleCol = blackHolesIndexes.get(1);
            secondHoleRow = blackHolesIndexes.get(2);
            secondHoleCol = blackHolesIndexes.get(3);
        }


        int collectedStars = 0;
        boolean isVoid = false;
        while (!isVoid && collectedStars < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (stephenRow - 1 < 0) {
                        isVoid = true;
                        matrix[stephenRow][stephenCol] = "-";
                    } else {
                        matrix[stephenRow][stephenCol] = "-";
                        stephenRow -= 1;
                        if (Character.isDigit(matrix[stephenRow][stephenCol].charAt(0))) {
                            collectedStars += Integer.parseInt(matrix[stephenRow][stephenCol]);
                            matrix[stephenRow][stephenCol] = "S";
                        } else if (matrix[stephenRow][stephenCol].equals("O")) {
                            if (stephenRow == firstHoleRow && stephenCol == firstHoleCol) {
                                matrix[firstHoleRow][firstHoleCol] = "-";
                                matrix[secondHoleRow][secondHoleCol] = "S";
                                stephenRow = secondHoleRow;
                                stephenCol = secondHoleCol;
                            } else {
                                matrix[secondHoleRow][secondHoleCol] = "-";
                                matrix[firstHoleRow][firstHoleCol] = "S";
                                stephenRow = firstHoleRow;
                                stephenCol = firstHoleCol;
                            }

                        } else {
                            matrix[stephenRow][stephenCol] = "S";
                        }
                    }

                    break;
                case "down":
                    if (stephenRow + 1 >= matrixSize) {
                        isVoid = true;
                        matrix[stephenRow][stephenCol] = "-";
                    } else {
                        matrix[stephenRow][stephenCol] = "-";
                        stephenRow += 1;
                        if (Character.isDigit(matrix[stephenRow][stephenCol].charAt(0))) {
                            collectedStars += Integer.parseInt(matrix[stephenRow][stephenCol]);
                            matrix[stephenRow][stephenCol] = "S";
                        } else if (matrix[stephenRow][stephenCol].equals("O")) {
                            if (stephenRow == firstHoleRow && stephenCol == firstHoleCol) {
                                matrix[firstHoleRow][firstHoleCol] = "-";
                                matrix[secondHoleRow][secondHoleCol] = "S";
                                stephenRow = secondHoleRow;
                                stephenCol = secondHoleCol;
                            } else {
                                matrix[secondHoleRow][secondHoleCol] = "-";
                                matrix[firstHoleRow][firstHoleCol] = "S";
                                stephenRow = firstHoleRow;
                                stephenCol = firstHoleCol;
                            }

                        } else {
                            matrix[stephenRow][stephenCol] = "S";
                        }
                    }
                    break;
                case "left":
                    if (stephenCol - 1 < 0) {
                        isVoid = true;
                        matrix[stephenRow][stephenCol] = "-";
                    } else {
                        matrix[stephenRow][stephenCol] = "-";
                        stephenCol -= 1;
                        if (Character.isDigit(matrix[stephenRow][stephenCol].charAt(0))) {
                            collectedStars += Integer.parseInt(matrix[stephenRow][stephenCol]);
                            matrix[stephenRow][stephenCol] = "S";
                        } else if (matrix[stephenRow][stephenCol].equals("O")) {
                            if (stephenRow == firstHoleRow && stephenCol == firstHoleCol) {
                                matrix[firstHoleRow][firstHoleCol] = "-";
                                matrix[secondHoleRow][secondHoleCol] = "S";
                                stephenRow = secondHoleRow;
                                stephenCol = secondHoleCol;
                            } else {
                                matrix[secondHoleRow][secondHoleCol] = "-";
                                matrix[firstHoleRow][firstHoleCol] = "S";
                                stephenRow = firstHoleRow;
                                stephenCol = firstHoleCol;
                            }

                        } else {
                            matrix[stephenRow][stephenCol] = "S";
                        }
                    }
                    break;
                case "right":
                    if (stephenCol + 1 >= matrixSize) {
                        isVoid = true;
                        matrix[stephenRow][stephenCol] = "-";
                    } else {
                        matrix[stephenRow][stephenCol] = "-";
                        stephenCol += 1;
                        if (Character.isDigit(matrix[stephenRow][stephenCol].charAt(0))) {
                            collectedStars += Integer.parseInt(matrix[stephenRow][stephenCol]);
                            matrix[stephenRow][stephenCol] = "S";
                        } else if (matrix[stephenRow][stephenCol].equals("O")) {
                            if (stephenRow == firstHoleRow && stephenCol == firstHoleCol) {
                                matrix[firstHoleRow][firstHoleCol] = "-";
                                matrix[secondHoleRow][secondHoleCol] = "S";
                                stephenRow = secondHoleRow;
                                stephenCol = secondHoleCol;
                            } else {
                                matrix[secondHoleRow][secondHoleCol] = "-";
                                matrix[firstHoleRow][firstHoleCol] = "S";
                                stephenRow = firstHoleRow;
                                stephenCol = firstHoleCol;
                            }

                        } else {
                            matrix[stephenRow][stephenCol] = "S";
                        }

                    }
                    break;
            }
        }
        if (isVoid) {
            System.out.println("Bad news, the spaceship went to the void.");
            System.out.println("Star power collected: " + collectedStars);
        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
            System.out.println("Star power collected: " + collectedStars);
        }
        printMatrix(matrix);
    }

}
