import java.util.Scanner;

public class GreaterTwoValues {
    static int getMax(int c, int d) {
        if (c > d) {
            return c;
        } else {
            return d;
        }
    }

    static char getMax(char a, char b) {
        if ((int) a > (int) b) {
            return a;
        } else {
            return b;
        }
    }

    static String getMax(String a, String b) {
        if (a.compareTo(b) >= 0) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        boolean isInt = false;
        boolean isChar = false;
        boolean isString = true;
        switch (type) {
            case "int":

                isInt = true;
                isString = false;
                break;
            case "char":

                isChar = true;
                isString = false;
                break;

        }
        if (isInt) {
            int c = Integer.parseInt(a);
            int d = Integer.parseInt(b);
            System.out.println(getMax(c, d));
        } else if (isChar) {
            char e = a.charAt(0);
            char f = b.charAt(0);
            System.out.println(getMax(e, f));
        } else {
            System.out.println(getMax(a, b));
        }
    }
}
