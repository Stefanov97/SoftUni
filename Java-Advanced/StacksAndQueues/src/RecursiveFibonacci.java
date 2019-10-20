import java.util.Scanner;

public class RecursiveFibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        long[] memory = new long[n + 1];

        long result = getFibonacci(n, memory);
        System.out.println(result);
    }

    private static long getFibonacci(int n, long[] memory) {
        if (n < 2) {
            return 1;
        }
        if (memory[n] != 0) {
            return memory[n];
        }
        return memory[n] = getFibonacci(n - 1, memory) + getFibonacci(n - 2, memory);
    }
}
