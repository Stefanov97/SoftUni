import java.util.*;
import java.util.stream.Collectors;

public class SumOfCoins {
    static int targetSum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().replace("Coins: ", "");
        List<Integer> coins = Arrays.stream(line.split(", ")).map(Integer::parseInt).sorted((f, s) -> s.compareTo(f)).collect(Collectors.toList());

        targetSum = Integer.parseInt(scanner.nextLine().replace("Sum: ", ""));

        Map<Integer, Integer> selectedCoins = chooseCoins(coins, targetSum);


        if (targetSum > 0) {
            System.out.println("Error");
        } else {
            int[] totalCoins = new int[1];
            selectedCoins.entrySet().forEach(entry -> {
                totalCoins[0] += entry.getValue();
            });
            System.out.println(String.format("Number of coins to take: %d", totalCoins[0]));
            selectedCoins.entrySet().forEach(entry -> {
                int coinValue = entry.getKey();
                int count = entry.getValue();
                System.out.println(String.format("%d coin(s) with value %d", count, coinValue));
            });
        }
    }

    private static Map<Integer, Integer> chooseCoins(List<Integer> coins, int sum) {
        Map<Integer, Integer> selectedCoins = new LinkedHashMap<>();
        for (int i = 0; i < coins.size(); i++) {
            int currentCoin = coins.get(i);
            while (currentCoin <= sum) {
                int countCoins = sum / currentCoin;
                sum -= countCoins * currentCoin;
                targetSum -= countCoins * currentCoin;

                selectedCoins.put(currentCoin, countCoins);
            }
        }
        return selectedCoins;
    }
}
