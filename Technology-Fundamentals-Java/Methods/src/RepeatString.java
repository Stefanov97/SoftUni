import java.util.Scanner;

public class RepeatString {
    static String printString(int repeatCount, String word) {
        String[] words = new String[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            words[i] = word;
        }
        return String.join("", words);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int repeatCount = Integer.parseInt(scanner.nextLine());


        System.out.println(printString(repeatCount, word));
    }
}
