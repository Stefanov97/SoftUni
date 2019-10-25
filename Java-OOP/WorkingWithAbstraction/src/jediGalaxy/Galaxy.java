package jediGalaxy;

public class Galaxy {
    private int rows;
    private int cols;
    private int[][] matrix;

    public Galaxy(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new int[this.rows][this.cols];
        initializeMatrix(this.matrix, this.rows, this.cols);
    }

    private void initializeMatrix(int[][] matrix, int rows, int cols) {
        int value = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = value++;
            }
        }
    }

    public int[][] getMatrix() {
        return this.matrix;
    }
}
