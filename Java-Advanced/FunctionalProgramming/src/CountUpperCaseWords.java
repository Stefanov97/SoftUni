import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUpperCaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s");
        Consumer<String> printWord = word -> System.out.println(word);

        Predicate<String> isUpperCaseWord = word -> Character.isUpperCase(word.charAt(0));

        List<String> result = Arrays.stream(tokens).filter(isUpperCaseWord).collect(Collectors.toList());
        System.out.println(result.size());
        result.forEach(printWord);
    }
}
