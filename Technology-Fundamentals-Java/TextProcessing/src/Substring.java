import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bannedWord = scanner.nextLine();
        String input = scanner.nextLine();
        int index = input.indexOf(bannedWord);

        while (index >= 0) {

            input = input.replace(bannedWord, "");
            index = input.indexOf(bannedWord);

        }
        System.out.println(input);
    }
}
