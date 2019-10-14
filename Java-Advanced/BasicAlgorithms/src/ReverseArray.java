import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        printArr(arr, arr.length - 1);
    }

    private static void printArr(int[] arr, int index) {
        if (index == 0) {
            System.out.print(arr[index]);
            return;
        }
        System.out.print(arr[index] + " ");
        printArr(arr, index - 1);

    }
}
