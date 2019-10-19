import java.util.*;

public class JobMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = new String[3][3];

        for (int rows = 0; rows < 3; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < 3; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }

        Map<String, String> results = new LinkedHashMap<>();

        for (int rows = 0; rows < 3; rows++) {
            for (int cols = 0; cols < 3; cols++) {
                String letter = matrix[rows][cols];
                String neighbours = findNeighbours(matrix, rows, cols);
                results.put(letter, neighbours);
                System.out.println(letter + " " + "the result is: " + neighbours);

            }
        }
        System.out.println();
    }

    private static String findNeighbours(String[][] matrix, int rows, int cols) {
        String neighbours = "";
        neighbours += findLeft(matrix, rows, cols);
        neighbours += findRight(matrix, rows, cols);
        neighbours += findUp(matrix, rows, cols);
        neighbours += findDown(matrix, rows, cols);
        neighbours += findFirstDiagonal(matrix, rows, cols);
        neighbours += findSecondDiagonal(matrix, rows, cols);
        neighbours += findThirdDiagonal(matrix, rows, cols);
        neighbours += findFourthDiagonal(matrix, rows, cols);

        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < neighbours.length(); i++) {
            tokens.add(neighbours.charAt(i) + "");
        }
        Collections.sort(tokens);
        String output = "";
        for (int i = 0; i < tokens.size(); i++) {
            output += tokens.get(i);
        }

        return output;
    }

    private static String findFourthDiagonal(String[][] matrix, int rows, int cols) {
        String fourthDiagonal = "";
        if (rows == 0 || cols == 2) {
            return fourthDiagonal;
        }
        fourthDiagonal = matrix[rows - 1][cols + 1];

        return fourthDiagonal;
    }

    private static String findThirdDiagonal(String[][] matrix, int rows, int cols) {
        String thirdDiagonal = "";
        if (rows == 2 || cols == 0) {
            return thirdDiagonal;
        }

        thirdDiagonal = matrix[rows + 1][cols - 1];

        return thirdDiagonal;
    }

    private static String findSecondDiagonal(String[][] matrix, int rows, int cols) {
        String secondDiagonal = "";
        if (rows == 2 || cols == 2) {
            return secondDiagonal;
        }
        secondDiagonal = matrix[rows + 1][cols + 1];
        return secondDiagonal;
    }

    private static String findFirstDiagonal(String[][] matrix, int rows, int cols) {
        String firstDiagonal = "";
        if (rows == 0 || cols == 0) {
            return firstDiagonal;
        }
        firstDiagonal = matrix[rows - 1][cols - 1];

        return firstDiagonal;
    }

    private static String findDown(String[][] matrix, int rows, int cols) {
        String down = "";
        if (rows == 2) {
            return down;
        }
        down = matrix[rows + 1][cols];
        return down;
    }

    private static String findUp(String[][] matrix, int rows, int cols) {
        String up = "";
        if (rows == 0) {
            return up;
        }
        up = matrix[rows - 1][cols];
        return up;
    }

    private static String findRight(String[][] matrix, int rows, int cols) {
        String right = "";
        if (cols == 2) {
            return right;
        }
        right = matrix[rows][cols + 1];

        return right;
    }
    private static String findLeft(String[][] matrix, int rows, int cols) {
        String left = "";
        if (cols == 0) {
            return left;
        }

        left = matrix[rows][cols - 1];

        return left;
    }
}
