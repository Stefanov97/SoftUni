import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, HashSet<String>> players = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!"JOKER".equals(line)) {
            String name = line.substring(0, line.indexOf(":"));
            String[] cards = line.substring(line.indexOf(":") + 2, line.length()).split(", ");
            players.putIfAbsent(name, new HashSet<>());
            players.get(name).addAll(Arrays.asList(cards));

            line = scanner.nextLine();
        }

        players.entrySet().stream().forEach((player) -> {
            int sum = calculateSum(player.getValue());

            System.out.println(player.getKey() + ": " + sum);
        });
    }

    private static int calculateSum(HashSet<String> deck) {
        int totalSum = 0;


        for (String card : deck) {
            int currentSum = 0;
            if (Character.isDigit(card.charAt(0)) && card.charAt(0) != '1') {
                currentSum += Integer.parseInt(card.charAt(0) + "");
                switch (card.charAt(card.length() - 1)) {
                    case 'S':
                        currentSum *= 4;
                        break;
                    case 'H':
                        currentSum *= 3;
                        break;
                    case 'D':
                        currentSum *= 2;
                        break;
                }

            } else {
                switch (card.charAt(0)) {
                    case '1':
                        currentSum += 10;
                        break;
                    case 'J':
                        currentSum += 11;
                        break;
                    case 'Q':
                        currentSum += 12;
                        break;
                    case 'K':
                        currentSum += 13;
                        break;
                    case 'A':
                        currentSum += 14;
                        break;
                }

                switch (card.charAt(card.length() - 1)) {
                    case 'S':
                        currentSum *= 4;
                        break;
                    case 'H':
                        currentSum *= 3;
                        break;
                    case 'D':
                        currentSum *= 2;
                        break;

                }
            }
            totalSum += currentSum;
        }

        return totalSum;
    }
}
