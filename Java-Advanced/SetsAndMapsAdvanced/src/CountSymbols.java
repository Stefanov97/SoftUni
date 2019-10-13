import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> symbols = new TreeMap<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            symbols.putIfAbsent(symbol, 0);
            symbols.put(symbol, symbols.get(symbol) + 1);
        }

        symbols.entrySet().forEach(entry -> {
            char symbol = entry.getKey();
            int value = entry.getValue();
            System.out.println(String.format("%s: %d time/s", symbol, value));
        });
    }
}
