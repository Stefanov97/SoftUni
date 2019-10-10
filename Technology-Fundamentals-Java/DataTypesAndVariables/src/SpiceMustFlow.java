import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int yeld = Integer.parseInt(scanner.nextLine());
        int extracted = 0;
        int days = 0;
        while (yeld >= 100) {
            days++;
            extracted += yeld - 26;
            yeld -= 10;
        }
        System.out.println(days);
        if (extracted >= 26) {
            extracted -= 26;
        }
        System.out.println(extracted);
    }
}
