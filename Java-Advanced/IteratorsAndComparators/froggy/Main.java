import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());

        Lake lake = new Lake(numbers);
        Lake.Frog frog = lake.new Frog();
        frog.addAll(numbers);
        List<Integer> firstJumped = frog.getFirstJumped();
        List<Integer> secondJumped = frog.getSecondJumped();

        System.out.print(String.join(", ", firstJumped.stream().map(String::valueOf).collect(Collectors.toList())));
        if (!secondJumped.isEmpty()) {
            System.out.print(", ");
        }
        System.out.println(String.join(", ", secondJumped.stream().map(String::valueOf).collect(Collectors.toList())));
    }
}
