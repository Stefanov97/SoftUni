import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split(" +");
        String firstWord = tokens[0];
        String secondWord = tokens[1];

        int sum = getSum(firstWord, secondWord);
        System.out.println(sum);
    }

    private static int getSum(String firstWord, String secondWord) {
        int sum = 0;
        if (firstWord.length() == secondWord.length()) {
            for (int i = 0; i < firstWord.length(); i++) {
                char letter = firstWord.charAt(i);
                char secondLetter = secondWord.charAt(i);
                sum += (int) letter * (int) secondLetter;
            }
        } else if (firstWord.length() < secondWord.length()) {
            int index = 0;
            for (int i = 0; i < firstWord.length(); i++) {
                char letter = firstWord.charAt(i);
                char secondLetter = secondWord.charAt(i);
                sum += (int) letter * (int) secondLetter;
                index++;
            }
            for (int i = index; i < secondWord.length(); i++) {
                char letter = secondWord.charAt(i);
                sum += (int) letter;
            }
        } else {
            int index = 0;
            for (int i = 0; i < secondWord.length(); i++) {
                char letter = firstWord.charAt(i);
                char secondLetter = secondWord.charAt(i);
                sum += (int) letter * (int) secondLetter;
                index++;
            }
            for (int i = index; i < firstWord.length(); i++) {
                char letter = firstWord.charAt(i);
                sum += (int) letter;
            }
        }
        return sum;
    }
}
