package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readCoordinates(scanner);

        Galaxy galaxy = new Galaxy(dimensions[0], dimensions[1]);
        int[][] matrix = galaxy.getMatrix();
        Player player = new Player();

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            int[] playerCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int playerRow = playerCoordinates[0];
            int playerCol = playerCoordinates[1];

            int[] evilCoordinates = readCoordinates(scanner);
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];


            while (evilRow >= 0 && evilCol >= 0) {
                if (evilRow < matrix.length && evilCol < matrix[0].length) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }
            player.collectStars(matrix, playerRow, playerCol);

            command = scanner.nextLine();
        }

        System.out.println(player.getCollectedStars());


    }

    private static int[] readCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
