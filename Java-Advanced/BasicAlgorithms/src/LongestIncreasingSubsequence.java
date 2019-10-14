import java.util.*;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] len = new int[sequence.length];
        int[] prev = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            int bestLength = 1;
            int previousIndexWithBestSequence = -1;

            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    if (len[j] + 1 > bestLength) {
                        bestLength = len[j] + 1;
                        previousIndexWithBestSequence = j;
                    }
                }
            }
            len[i] = bestLength;
            prev[i] = previousIndexWithBestSequence;
        }

        int bestLength = 0;
        int bestIndex = -1;
        for (int i1 = 0; i1 < len.length; i1++) {
            int i = len[i1];
            if (i > bestLength) {
                bestLength = i;
                bestIndex = i1;

            }
        }

        List<Integer> result = new ArrayList<>();
        int currentIndex = 0;
        while (bestIndex != -1) {
            result.add(sequence[bestIndex]);
            bestIndex = prev[bestIndex];
        }
        Collections.reverse(result);
        for (Integer num : result) {
            System.out.print(num + " ");
        }
    }
}
