import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(":")).map(Integer::parseInt).collect(Collectors.toList());
        int totalFromNumbers = 0;
        for (Integer number : numbers) {
            totalFromNumbers += number;
        }

        String regex = " ?:([a-z]{4,}):[ .,!?]"; // ?:([a-z]{4,}):[ .,!?]
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(message);
        int totalEmojiPower = 0;
        boolean isEqual = false;
        boolean isFound = false;
        List<String> validEmojies = new ArrayList<>();

        while (matcher.find()) {
            boolean isValid = true;
            isFound = true;
            String emoji = matcher.group(1);
            int indexOfSpace = message.indexOf(emoji) - 2;
            if (message.charAt(indexOfSpace) != ' ') {
                isValid = false;
            }
            if (isValid) {
                validEmojies.add(emoji);
                int currentEmojiPower = 0;
                for (int i = 0; i < emoji.length(); i++) {
                    totalEmojiPower += emoji.charAt(i);
                    currentEmojiPower += emoji.charAt(i);
                }
                if (currentEmojiPower == totalFromNumbers) {
                    isEqual = true;
                }
            }
        }
        if (isFound) {
            System.out.print("Emojis found: ");
            int index = 0;
            for (String emojy : validEmojies) {
                if (index == validEmojies.size() - 1) {
                    System.out.printf(":%s:", emojy);
                } else {
                    System.out.printf(":%s:, ", emojy);
                }
                index++;
            }
            System.out.println();
        }
        if (isEqual) {
            totalEmojiPower *= 2;
        }
        System.out.printf("Total Emoji Power: %d", totalEmojiPower);
    }
}
