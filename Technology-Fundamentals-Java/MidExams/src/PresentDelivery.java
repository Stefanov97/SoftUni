import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> housesWithMembers = Arrays.stream(scanner.nextLine().split("@+")).map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();
        int currentIndex = 0;
        while (!"Merry Xmas!".equals(line)) {
            String[] allCommands = line.split(" +");
            int length = Integer.parseInt(allCommands[1]);
            currentIndex = (currentIndex + length) % housesWithMembers.size();
            int currentNumber = housesWithMembers.get(currentIndex);
            if (currentNumber > 0) {
                housesWithMembers.set(currentIndex, currentNumber - 2);
            } else {
                System.out.printf("House %d will have a Merry Christmas.", currentIndex).println();
            }
            line = scanner.nextLine();
        }
        int failedHouses = 0;
        for (int i = 0; i < housesWithMembers.size(); i++) {
            if (housesWithMembers.get(i) != 0) {
                failedHouses++;
            }
        }
        System.out.printf("Santa's last position was %d.", currentIndex).println();
        if (failedHouses != 0) {
            System.out.printf("Santa has failed %d houses.", failedHouses);
        } else {
            System.out.printf("Mission was successful.");
        }
    }
}
