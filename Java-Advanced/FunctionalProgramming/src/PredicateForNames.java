import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int validLength = Integer.parseInt(scanner.nextLine());
        List<String> allNames = Arrays.stream(scanner.nextLine().split("\\s")).collect(Collectors.toList());
        Predicate<String> isValidName = name -> name.length() <= validLength;
        Consumer<String> printAllValidNames = name -> System.out.println(name);
        allNames.stream().filter(isValidName).forEach(printAllValidNames);
    }
}
