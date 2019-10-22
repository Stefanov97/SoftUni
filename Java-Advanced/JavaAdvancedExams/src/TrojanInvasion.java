import java.util.ArrayDeque;
import java.util.Scanner;

public class TrojanInvasion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> warriorsStack = new ArrayDeque<>();
        ArrayDeque<Integer> platesQueue = new ArrayDeque<>();
        String[] platesTokens = scanner.nextLine().split("\\s+");
        for (String plate : platesTokens) {
            platesQueue.offer(Integer.parseInt(plate));
        }
        int wavesCount = 1;
        while (n-- > 0) {

            String[] warriorsTokens = scanner.nextLine().split("\\s+");
            if (wavesCount % 3 == 0) {
                int additionalPlate = Integer.parseInt(scanner.nextLine());
                platesQueue.offer(additionalPlate);
            }

            for (String warr : warriorsTokens) {
                warriorsStack.push(Integer.parseInt(warr));
            }
            while (!warriorsStack.isEmpty() && !platesQueue.isEmpty()) {
                int currentWarrior = warriorsStack.pop();
                int currentPlate = platesQueue.poll();
                if (currentWarrior > currentPlate) {

                    int newWarrValue = currentWarrior - currentPlate;
                    warriorsStack.push(newWarrValue);
                } else if (currentPlate > currentWarrior) {
                    int newPlateValue = currentPlate - currentWarrior;
                    platesQueue.offerFirst(newPlateValue);

                }
            }

            if (platesQueue.isEmpty()) {
                break;
            }
            wavesCount++;
        }

        if (platesQueue.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            int index = 0;
            System.out.print("Warriors left: ");
            for (Integer warr : warriorsStack) {
                if (index == warriorsStack.size() - 1) {
                    System.out.print(warr);
                } else {
                    System.out.print(warr + ", ");
                }
                index++;
            }

        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            int index = 0;
            for (Integer plate : platesQueue) {
                if (index == platesQueue.size() - 1) {
                    System.out.print(plate);
                } else {
                    System.out.print(plate + ", ");
                }
                index++;
            }
        }
    }
}
