import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();
        while (n-- > 0) {
            String str = scanner.nextLine();
            Box<String> stringBox = new Box<>(str);
            boxes.add(stringBox);

        }
        String element = scanner.nextLine();

        System.out.println(countGreaterStrings(boxes, element));
    }

    private static <T extends Comparable<T>> int countGreaterStrings(List<Box<T>> collection, T element) {
        int count = 0;
        for (Box<T> tBox : collection) {
            if (tBox.getElement().compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    private static <T extends Comparable<T>> void swapElements(List<Box<T>> boxes, int firstIndex, int secondIndex) {
        Box<T> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);

    }
}
