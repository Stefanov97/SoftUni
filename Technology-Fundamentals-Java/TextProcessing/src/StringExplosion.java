import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] array = input.toCharArray();
        List<Character> text = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            text.add(array[i]);
        }
        int toAdd = 0;
        for (int i = 0; i < text.size(); i++) {
            if (text.get(i) == '>') {
                int strength = Integer.parseInt(String.valueOf(text.get(i + 1))) + toAdd;
                boolean isLeft = false;
                while (strength > 0 && (i + 1) < text.size()) {
                    if (text.get(i + 1) == '>') {
                        toAdd += strength;
                        isLeft = true;
                        break;

                    } else {

                        text.remove(i + 1);


                    }
                    strength--;
                }
                if (!isLeft) {
                    toAdd = 0;
                }
            }

        }
        for (Character character : text) {
            System.out.print(character);
        }

    }
}
