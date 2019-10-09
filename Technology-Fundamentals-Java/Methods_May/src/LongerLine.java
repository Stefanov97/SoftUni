import java.text.DecimalFormat;
import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());

        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());


        printLongerLine(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    private static double distanceToCenter(double x, double y) {
        return Math.sqrt(Math.pow((0 - x), 2) + Math.pow((0 - y), 2));

    }

    static double lineLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    static void printClosestPointFirst(double x1, double y1, double x2, double y2) {
        if (distanceToCenter(x1, y1) > distanceToCenter(x2, y2)) {
            System.out.print("(");
            System.out.print(new DecimalFormat("0.####").format(x2));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.####").format(y2));
            System.out.print(")");
            System.out.print("(");
            System.out.print(new DecimalFormat("0.####").format(x1));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.####").format(y1));
            System.out.print(")");

        } else {
            System.out.print("(");
            System.out.print(new DecimalFormat("0.####").format(x1));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.####").format(y1));
            System.out.print(")");
            System.out.print("(");
            System.out.print(new DecimalFormat("0.####").format(x2));
            System.out.print(", ");
            System.out.print(new DecimalFormat("0.####").format(y2));
            System.out.print(")");

        }
    }

    static void printLongerLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        if (lineLength(x1, y1, x2, y2) >= lineLength(x3, y3, x4, y4)) {
            printClosestPointFirst(x1, y1, x2, y2);
        } else if (lineLength(x1, y1, x2, y2) < lineLength(x3, y3, x4, y4)) {
            printClosestPointFirst(x3, y3, x4, y4);
        }
    }
}
