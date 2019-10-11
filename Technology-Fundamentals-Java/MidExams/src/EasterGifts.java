import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> gifts = Arrays.stream(scanner.nextLine().split(" +")).collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"No Money".equals(line)) {
            String[] allCommands = line.split(" +");
            String main = allCommands[0];
            String gift = allCommands[1];

            switch (main) {
                case "OutOfStock":
                    while (gifts.contains(gift)) {
                        int giftIndex = gifts.indexOf(gift);
                        gifts.set(giftIndex, "None");
                    }
                    break;
                case "Required":
                    int index = Integer.parseInt(allCommands[2]);
                    if (index >= 0 && index < gifts.size()) {
                        gifts.set(index, gift);
                    }
                    break;
                case "JustInCase":
                    int lastIndex = gifts.size() - 1;
                    gifts.set(lastIndex, gift);
                    break;
            }
            line = scanner.nextLine();
        }
        for (String gift : gifts) {
            if (!gift.equals("None")) {
                System.out.print(gift + " ");
            }
        }
    }
}
