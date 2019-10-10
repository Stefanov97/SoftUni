import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 1 2 2 3

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        int leftSum = 0;
        boolean areEqual = false;
        for (int i = 0; i < numbers.length; i++) {
            if (i > 0) {
                leftSum += numbers[i - 1];
            }
            int rightSum = 0;
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum) {
                areEqual = true;
                index = i;
                break;
            }

        }
        if (areEqual) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
