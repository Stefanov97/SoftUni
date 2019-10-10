import java.util.Arrays;
import java.util.Scanner;

public class Zig_zag_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] first = new int[n];
        int[] second = new int[n];

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 0) {
                first[i] = input[0];
                second[i] = input[1];
            } else {
                first[i] = input[1];
                second[i] = input[0];
            }
        }
        for (int num : first) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int secNum : second) {
            System.out.print(secNum + " ");
        }
    }
}
