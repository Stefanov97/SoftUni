import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CookingFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int bestValue = Integer.MIN_VALUE;
        List<Integer> bestBatch = new ArrayList<>();

        while (!"Bake It!".equals(line)) {
            int[] batch = Arrays.stream(line.split("#+")).mapToInt(Integer::parseInt).toArray();

            int currentValue = 0;
            for (int i = 0; i < batch.length; i++) {
                currentValue += batch[i];
            }
            if (currentValue > bestValue) {
                bestValue = currentValue;
                bestBatch.removeAll(bestBatch);
                for (int i = 0; i < batch.length; i++) {
                    bestBatch.add(batch[i]);
                }
            } else if (currentValue == bestValue) {

                if (currentValue != 0) {
                    if (batch.length / currentValue > bestBatch.size() / bestValue) {
                        bestBatch.removeAll(bestBatch);
                        for (int i = 0; i < batch.length; i++) {
                            bestBatch.add(batch[i]);
                        }
                    } else if (batch.length / currentValue == bestBatch.size() / bestValue) {
                        if (batch.length < bestBatch.size()) {
                            bestBatch.removeAll(bestBatch);
                            for (int i = 0; i < batch.length; i++) {
                                bestBatch.add(batch[i]);
                            }
                        }
                    }
                } else if (currentValue == 0) {
                    if (batch.length < bestBatch.size()) {
                        bestBatch.removeAll(bestBatch);
                        for (int i = 0; i < batch.length; i++) {
                            bestBatch.add(batch[i]);
                        }
                    }
                }
            }
            line = scanner.nextLine();
        }
        System.out.printf("Best Batch quality: %d", bestValue).println();
        for (Integer batch : bestBatch) {
            System.out.print(batch + " ");
        }

    }
}
