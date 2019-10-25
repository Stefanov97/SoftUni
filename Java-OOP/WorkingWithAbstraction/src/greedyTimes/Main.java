
package greedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(bagCapacity);


        for (int i = 0; i < input.length; i += 2) {
            String name = input[i];
            long quantity = Long.parseLong(input[i + 1]);

            if (bag.getCapacity() >= quantity) {
                if (name.length() == 3) {
                    Cash cash = new Cash(name, quantity);
                    bag.addCash(cash);
                } else if (name.toLowerCase().endsWith("gem")) {
                    Gem gem = new Gem(name, quantity);
                    bag.addGems(gem);
                } else if (name.toLowerCase().equals("gold")) {
                    Gold gold = new Gold(quantity);
                    bag.addGold(gold);
                }
            }
        }
        System.out.println(bag.toString());
    }
}
