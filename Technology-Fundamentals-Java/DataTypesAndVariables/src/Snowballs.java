import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double maxValue = Integer.MIN_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int maxSnow = Integer.MIN_VALUE;
        int maxQuality = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);
            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                maxTime = snowballTime;
                maxSnow = snowballSnow;
                maxQuality = snowballQuality;
            }

        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}
