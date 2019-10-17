import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String str = scanner.nextLine();
            Box<String> box = new Box(str);
            System.out.println(box.toString());

        }

    }
}
