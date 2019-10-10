import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthOfSequences = Integer.parseInt(scanner.nextLine());

        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSum = 0;
        int bestIndexRow = 0;
        int bestIndexRowOutput = 0;

        int[] bestSequenceDNA = new int[lengthOfSequences];

        String input = scanner.nextLine();
        while (!"Clone them!".equals(input)) {
            ++bestIndexRow;
            int[] sequence = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            int bestIndex = 0;
            int bestSequence = 0;

            for (int i = 0; i < sequence.length; i++) {
                int currentSequence = 1;                       //1!0!1!1!0
                for (int j = i + 1; j < sequence.length; j++) {
                    if (sequence[i] == sequence[j] && sequence[i] != 0) {
                        currentSequence++;

                    } else {
                        break;
                    }
                }
                if (currentSequence > bestSequence) {
                    bestSequence = currentSequence;
                    bestIndex = i;
                }


            }
            int currentSum = 0;
            for (int i = 0; i < sequence.length; i++) {
                currentSum += sequence[i];
            }
            if (bestIndex < bestSequenceIndex) {
                bestSum = currentSum;
                bestSequenceIndex = bestIndex;
                bestIndexRowOutput = bestIndexRow;
                for (int i = 0; i < sequence.length; i++) {
                    bestSequenceDNA[i] = sequence[i];
                }

            } else if (bestIndex == bestSequenceIndex) {
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestSequenceIndex = bestIndex;
                    bestIndexRowOutput = bestIndexRow;
                    for (int i = 0; i < sequence.length; i++) {
                        bestSequenceDNA[i] = sequence[i];
                    }
                }
            }


            input = scanner.nextLine();

        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestIndexRowOutput, bestSum);
        for (int i = 0; i < bestSequenceDNA.length; i++) {
            System.out.print(bestSequenceDNA[i] + " ");
        }

    }
}
