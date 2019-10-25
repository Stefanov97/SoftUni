package jediGalaxy;

public class Player {
    private long starsCollected;

    public Player() {
        this.starsCollected = 0;
    }

    public void addStars(int value) {
        this.starsCollected += value;
    }

    public long getCollectedStars() {
        return this.starsCollected;
    }

    public void collectStars(int[][] matrix, int playerRow, int playerCol) {
        while (playerRow >= 0 && playerCol < matrix[1].length) {
            if (playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length) {
                this.addStars(matrix[playerRow][playerCol]);
            }
            playerCol++;
            playerRow--;
        }
    }
}
