import java.util.Arrays;
import java.util.Scanner;

public class TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" +")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            boolean isTopInteger = false;
            if (array[i] == array[array.length - 1]) {
                isTopInteger = true;
            }

            for (int j = i; j < array.length - 1; j++) {
                if (array[i] > array[j + 1]) {
                    isTopInteger = true;
                } else {
                    isTopInteger = false;
                    break;
                }
            }

            if (isTopInteger) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
