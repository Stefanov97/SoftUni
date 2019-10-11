import java.util.Scanner;

public class GoogleSearches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalDays = Integer.parseInt(scanner.nextLine());
        int users = Integer.parseInt(scanner.nextLine());
        double moneyPerSearch = Double.parseDouble(scanner.nextLine());
        double totalProfit = 0;

        for (int i = 1; i <= users; i++) {
            int words = Integer.parseInt(scanner.nextLine());
            if (words != 0) {
                if (i % 3 == 0 && words == 1) {
                    totalProfit += moneyPerSearch * 3 * totalDays * 2;
                    continue;
                } else if (i % 3 == 0 && words < 6) {
                    totalProfit += moneyPerSearch * totalDays * 3;
                    continue;
                }
                if (words == 1) {
                    totalProfit += moneyPerSearch * 2 * totalDays;

                } else if (words < 6) {
                    totalProfit += moneyPerSearch * totalDays;
                }
            }
        }
        System.out.printf("Total money earned for %d days: %.2f", totalDays, totalProfit);
    }
}
