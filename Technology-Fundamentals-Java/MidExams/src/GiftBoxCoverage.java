import java.util.Scanner;

public class GiftBoxCoverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sideSize = Double.parseDouble(scanner.nextLine());
        int numberSheets = Integer.parseInt(scanner.nextLine());
        double areaSingleSheetCovers = Double.parseDouble(scanner.nextLine());

        double area = sideSize * sideSize * 6;

        int smallerSheets = numberSheets / 3;
        int biggerSheets = numberSheets - smallerSheets;

        double areaSmallerSheetCovers = areaSingleSheetCovers * 0.25;

        double coveredArea = (smallerSheets * areaSmallerSheetCovers) + (biggerSheets * areaSingleSheetCovers);

        double percentage = (coveredArea / area) * 100;

        System.out.printf("You can cover %.2f%% of the box.", percentage);
    }
}
