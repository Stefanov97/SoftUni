import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numberToOffer = Integer.parseInt(input[0]);
        int elementsToPoll = Integer.parseInt(input[1]);
        int numberToLookFor = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).limit(numberToOffer).forEach(e -> queue.offer(e));

        while (elementsToPoll-- > 0) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else {
            if (queue.contains(numberToLookFor)) {
                System.out.println("true");
            } else {
                System.out.println(Collections.min(queue));
            }
        }

    }
}
