import java.util.Scanner;

public class NestedLoopsToRecursion {
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n];

        printAllPossibilities(n, 0);

    }

    private static void printAllPossibilities(int n, int index) {
        if (index == arr.length) {
            for (int i : arr) {
                System.out.print(i + " ");
            }

            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            arr[index] = i;
            printAllPossibilities(n, index + 1);
        }
    }
}
