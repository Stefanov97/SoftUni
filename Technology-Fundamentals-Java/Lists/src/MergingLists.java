import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        if (firstList.size() <= secondList.size()) {
            int index = 0;
            for (int i = 0; i < firstList.size(); i++) {
                result.add(firstList.get(i));
                result.add(secondList.get(i));
                index++;
            }
            for (int i = index; i < secondList.size(); i++) {
                result.add(secondList.get(i));
            }
        } else {
            int index = 0;
            for (int i = 0; i < secondList.size(); i++) {
                result.add(firstList.get(i));
                result.add(secondList.get(i));
                index++;
            }
            for (int i = index; i < firstList.size(); i++) {
                result.add(firstList.get(i));
            }
        }

        for (int number : result) {
            System.out.print(number + " ");
        }

    }
}
