import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" +")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (!numbers.isEmpty()) {
            boolean isLower = false;
            boolean isGreater = false;
            int index = Integer.parseInt(scanner.nextLine());
            int numberSum = 0;
            if (index < 0) {
                index = 0;
                isLower = true;
            }
            if (index > numbers.size() - 1) {
                index = numbers.size() - 1;
                isGreater = true;
            }
            numberSum = numbers.get(index);
            sum += numbers.get(index);
            numbers.remove(index);
            if (isLower) {
                numbers.add(index, numbers.get(numbers.size() - 1));
            }
            if (isGreater) {
                numbers.add(index, numbers.get(0));
            }


            for (int i = 0; i < numbers.size(); i++) {
                int currentNumber = numbers.get(i);
                if (currentNumber <= numberSum) {
                    numbers.set(i, currentNumber + numberSum);
                } else {
                    numbers.set(i, currentNumber - numberSum);
                }
            }


        }
        System.out.println(sum);
    }
}
