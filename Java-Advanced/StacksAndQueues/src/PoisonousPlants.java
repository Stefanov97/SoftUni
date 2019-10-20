import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(buffer.readLine());
        String[] plants = buffer.readLine().split(" ");

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] deathDays = new int[n];
        for (int i = 1; i < n; i++) {

            int maxDays = 0;

            while (!indexes.isEmpty() && Integer.valueOf(plants[indexes.peek()]) >= Integer.valueOf(plants[i])) {
                maxDays = Math.max(maxDays, deathDays[indexes.pop()]);
            }

            if (!indexes.isEmpty()) {
                deathDays[i] = maxDays + 1;
            }

            indexes.push(i);
        }
        System.out.println(max(deathDays));
    }

    private static int max(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }
}