import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scanner.nextLine());
        int[] encryptedNames = new int[sequenceLength];
        for (int i = 0; i < sequenceLength; i++) {
            String word = scanner.nextLine();
            int sum = 0;
            for (int j = 0; j < word.length(); j++) {
                String letter = String.valueOf(word.charAt(j));
                char letterToSum = word.charAt(j);
                if (letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e")
                        || letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o") ||
                        letter.equalsIgnoreCase("u")) {

                    sum += (int) letterToSum * word.length();

                } else {
                    sum += (int) letterToSum / word.length();
                }
            }
            encryptedNames[i] = sum;

        }
        for (int i = 0; i < encryptedNames.length; i++) {
            printSmallest(encryptedNames);
        }
    }

    static void printSmallest(int[] encryptedNames) {
        for (int i = 0; i < encryptedNames.length; i++) {
            boolean isSmallest = false;
            for (int j = 0; j < encryptedNames.length; j++) {
                if (encryptedNames[i] <= encryptedNames[j] && encryptedNames[i] != 99999) {
                    isSmallest = true;

                } else {
                    isSmallest = false;
                    break;
                }
            }
            if (isSmallest) {
                System.out.println(encryptedNames[i]);
                encryptedNames[i] = 99999;
            }

        }
    }
}
