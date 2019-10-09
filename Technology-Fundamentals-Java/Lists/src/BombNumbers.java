import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> bombNumber = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        int power = bombNumber.get(1);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(bombNumber.get(0))) {


                while (power-- > 0) {
                    boolean isRemoved = false;
                    for (int j = 0; j < numbers.size(); j++) {
                        if (numbers.get(j).equals(bombNumber.get(0))) {
                            if (j - 1 >= 0) {
                                numbers.remove(j - 1);
                                isRemoved = true;
                            }
                            if (isRemoved && j < numbers.size()) {
                                numbers.remove(j);
                            } else {
                                if (j + 1 < numbers.size()) {
                                    numbers.remove(j + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            if (!number.equals(bombNumber.get(0))) {
                sum += number;
            }
        }
        System.out.println(sum);
    }
}
