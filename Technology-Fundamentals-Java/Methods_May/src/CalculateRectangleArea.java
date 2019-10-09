import java.util.Scanner;

public class CalculateRectangleArea {
    static double calculateArea(double width, double height) {
        return width * height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        System.out.println((int) calculateArea(width, height));

    }
}
