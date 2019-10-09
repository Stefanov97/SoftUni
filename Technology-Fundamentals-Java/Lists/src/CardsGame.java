import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        while (firstDeck.size() != 0 && secondDeck.size() != 0) {
            if (firstDeck.get(0) > secondDeck.get(0)) {
                firstDeck.add(firstDeck.get(0));
                firstDeck.remove(0);
                firstDeck.add(secondDeck.get(0));
                secondDeck.remove(0);
            } else if (secondDeck.get(0) > firstDeck.get(0)) {
                secondDeck.add(secondDeck.get(0));
                secondDeck.remove(0);
                secondDeck.add(firstDeck.get(0));
                firstDeck.remove(0);
            } else if (firstDeck.get(0).equals(secondDeck.get(0))) {
                firstDeck.remove(0);
                secondDeck.remove(0);
            }
        }
        if (firstDeck.isEmpty()) {
            int sum = 0;
            for (int i = 0; i < secondDeck.size(); i++) {
                sum += secondDeck.get(i);
            }
            System.out.println("Second player wins! Sum: " + sum);
        } else {
            int sum = 0;
            for (int i = 0; i < firstDeck.size(); i++) {
                sum += firstDeck.get(i);
            }
            System.out.println("First player wins! Sum: " + sum);
        }
    }
}
