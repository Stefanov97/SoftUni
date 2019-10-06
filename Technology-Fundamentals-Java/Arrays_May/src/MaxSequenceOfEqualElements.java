import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxSequence = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            int sequence = 1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    sequence++;
                } else {
                    break;
                }
            }
            if (sequence > maxSequence) {
                maxSequence = sequence;
                index = i;

            }
        }
        for (int i = index; i < index + maxSequence; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
