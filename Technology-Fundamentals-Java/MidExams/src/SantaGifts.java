import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> houses = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        int lastPosition = 0;

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" +");
            String command = tokens[0];
            int steps = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Forward":
                    if (lastPosition + steps < houses.size()) {
                        lastPosition += steps;
                        houses.remove(lastPosition);
                    }
                    break;
                case "Back":
                    if (lastPosition - steps >= 0) {
                        lastPosition -= steps;
                        houses.remove(lastPosition);
                    }
                    break;
                case "Gift":
                    int index = steps;
                    int houseNumber = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index <= houses.size()) {
                        houses.add(index, houseNumber);
                        lastPosition = index;
                    }
                    break;
                case "Swap":
                    int firstValue = steps;
                    int secondValue = Integer.parseInt(tokens[2]);
                    if (houses.contains(firstValue) && houses.contains(secondValue)) {
                        int firstIndex = houses.indexOf(firstValue);
                        int secondIndex = houses.indexOf(secondValue);
                        houses.set(firstIndex, secondValue);
                        houses.set(secondIndex, firstValue);
                    }
                    break;
            }
        }
        System.out.println("Position: " + lastPosition);
        int counter = 0;
        for (Integer house : houses) {

            if (counter == houses.size() - 1) {
                System.out.print(house);
            } else {
                System.out.print(house + ", ");
            }
            counter++;
        }
    }
}
