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
            Box<String> box = new Box(str);
            boxes.add(box);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        swapElements(boxes, firstIndex, secondIndex);
        for (Box<String> box : boxes) {
            System.out.println(box.toString());
        }
    }

    private static void swapElements(List<Box<String>> boxes, int firstIndex, int secondIndex) {
        Box<String> temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);

    }
}
