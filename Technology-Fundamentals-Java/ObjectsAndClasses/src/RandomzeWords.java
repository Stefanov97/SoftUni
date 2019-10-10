import java.util.Random;
import java.util.Scanner;

public class RandomzeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" +");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int randomNumber = random.nextInt(words.length);
            String oldFirst = words[i];
            words[i] = words[randomNumber];
            words[randomNumber] = oldFirst;
        }
        for (String word : words) {
            System.out.println(word);
        }

    }
}
