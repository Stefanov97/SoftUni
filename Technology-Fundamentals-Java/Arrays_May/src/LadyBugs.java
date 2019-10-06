import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());
        String[] indexesWithBug = scanner.nextLine().split(" +");
        int[] initialField = new int[fieldSize];

        for (int i = 0; i < indexesWithBug.length; i++) {
            int index = Integer.parseInt(indexesWithBug[i]);
            if (index >= 0 && index < fieldSize) {
                initialField[index] = 1;
            }
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] command = input.split(" +");
            int ladyBugIndex = Integer.parseInt(command[0]);
            String direction = command[1];
            int flyLength = Integer.parseInt(command[2]);

            if (ladyBugIndex < 0 || ladyBugIndex > fieldSize - 1 || initialField[ladyBugIndex] == 0) {
                input = scanner.nextLine();
                continue;
            } else {
                if (direction.equals("right")) {
                    initialField[ladyBugIndex] = 0;
                    ladyBugIndex += flyLength;
                    while (ladyBugIndex < fieldSize && initialField[ladyBugIndex] == 1) {
                        ladyBugIndex += flyLength;
                    }
                    if (ladyBugIndex < fieldSize) {
                        initialField[ladyBugIndex] = 1;
                    }
                } else {
                    initialField[ladyBugIndex] = 0;
                    ladyBugIndex -= flyLength;

                    while (ladyBugIndex >= 0 && initialField[ladyBugIndex] == 1) {
                        ladyBugIndex -= flyLength;
                    }
                    if (ladyBugIndex >= 0) {
                        initialField[ladyBugIndex] = 1;
                    }
                }
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < initialField.length; i++) {
            System.out.print(initialField[i] + " ");
        }
    }
}
