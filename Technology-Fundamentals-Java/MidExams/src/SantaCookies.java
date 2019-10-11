import java.util.Scanner;

public class SantaCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int batches = Integer.parseInt(scanner.nextLine());
        int totalBoxes = 0;

        for (int i = 0; i < batches; i++) {
            int flourGrams = Integer.parseInt(scanner.nextLine());
            int sugarGrams = Integer.parseInt(scanner.nextLine());
            int cocoaGrams = Integer.parseInt(scanner.nextLine());

            int flourCups = flourGrams / 140;
            int sugarSpoons = sugarGrams / 20;
            int cocoaSpoons = cocoaGrams / 10;
            if (flourCups <= 0 || sugarSpoons <= 0 || cocoaSpoons <= 0) {
                System.out.println("Ingredients are not enough for a box of cookies.");
                continue;
            }
            int minOfThis = Math.min(flourCups, Math.min(sugarSpoons, cocoaSpoons));
            int totalCookiesPerBake = ((140 + 10 + 20) * minOfThis) / 25;

            int boxesPerBatch = totalCookiesPerBake / 5;

            System.out.printf("Boxes of cookies: %d", boxesPerBatch).println();
            totalBoxes += boxesPerBatch;
        }
        System.out.printf("Total boxes: %d", totalBoxes);
    }
}
