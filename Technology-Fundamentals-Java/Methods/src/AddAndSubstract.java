import java.util.Scanner;

public class AddAndSubstract {
    static int getSumOfFirstTwo(int first, int second) {
        return first + second;
    }

    static int getSubstractOfTheSumAndTheThird(int firstTwo, int third) {
        return firstTwo - third;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        getSumOfFirstTwo(first, second);
        int result = getSubstractOfTheSumAndTheThird(getSumOfFirstTwo(first, second), third);
        System.out.println(result);
    }
}
