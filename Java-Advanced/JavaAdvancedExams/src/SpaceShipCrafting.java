import java.util.*;

public class SpaceShipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokensLiquids = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        for (String tokensLiquid : tokensLiquids) {
            liquidsQueue.offer(Integer.parseInt(tokensLiquid));
        }

        String[] tokensPhysical = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> itemsStack = new ArrayDeque<>();
        for (String token : tokensPhysical) {
            itemsStack.push(Integer.parseInt(token));
        }

        Map<String, Integer> craftedItems = new TreeMap<>();

        Map<Integer, String> table = new TreeMap<>();
        table.put(25, "Glass");
        table.put(50, "Aluminium");
        table.put(75, "Lithium");
        table.put(100, "Carbon fiber");

        while (!liquidsQueue.isEmpty() && !itemsStack.isEmpty()) {
            int sum = 0;
            int physicalItem = itemsStack.pop();
            sum = liquidsQueue.poll() + physicalItem;
            if (table.containsKey(sum)) {
                String item = table.get(sum);
                if (craftedItems.containsKey(item)) {
                    int prevSum = craftedItems.get(item);
                    craftedItems.put(item, prevSum + 1);
                } else {
                    craftedItems.put(item, 1);
                }
            } else {
                physicalItem += 3;
                itemsStack.push(physicalItem);
            }
        }
        if (craftedItems.containsKey("Glass") && craftedItems.containsKey("Aluminium") && craftedItems.containsKey("Lithium") && craftedItems.containsKey("Carbon fiber")) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        if (!liquidsQueue.isEmpty()) {
            System.out.print("Liquids left: ");
            while (!liquidsQueue.isEmpty()) {
                if (liquidsQueue.size() == 1) {
                    System.out.print(liquidsQueue.poll());
                } else {
                    System.out.print(liquidsQueue.poll() + ", ");
                }
            }
            System.out.println();

        } else {
            System.out.println("Liquids left: none");
        }

        if (!itemsStack.isEmpty()) {
            System.out.print("Physical items left: ");
            while (!itemsStack.isEmpty()) {
                if (itemsStack.size() == 1) {
                    System.out.print(itemsStack.pop());
                } else {
                    System.out.print(itemsStack.pop() + ", ");
                }
            }
            System.out.println();

        } else {
            System.out.println("Physical items left: none");
        }

        System.out.print("Aluminium: ");
        if (craftedItems.containsKey("Aluminium")) {
            System.out.print(craftedItems.get("Aluminium"));
        } else {
            System.out.print(0);
        }
        System.out.println();

        System.out.print("Carbon fiber: ");
        if (craftedItems.containsKey("Carbon fiber")) {
            System.out.print(craftedItems.get("Carbon fiber"));
        } else {
            System.out.print(0);
        }
        System.out.println();

        System.out.print("Glass: ");
        if (craftedItems.containsKey("Glass")) {
            System.out.print(craftedItems.get("Glass"));
        } else {
            System.out.print(0);
        }
        System.out.println();
        System.out.print("Lithium: ");
        if (craftedItems.containsKey("Lithium")) {
            System.out.print(craftedItems.get("Lithium"));
        } else {
            System.out.print(0);
        }
    }
}
