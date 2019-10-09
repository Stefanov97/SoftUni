
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> listOfNames = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" +");
            String name = input[0];
            String goingOrNot = input[2];
            if ("not".equals(goingOrNot)) {

                if (!listOfNames.contains(name)) {
                    System.out.printf("%s is not in the list!", name).println();
                } else {
                    listOfNames.remove(name);
                }


            } else {
                if (listOfNames.contains(name)) {
                    System.out.printf("%s is already in the list!", name).println();
                } else {
                    listOfNames.add(name);
                }

            }
        }
        for (String name : listOfNames) {
            System.out.println(name);
        }

    }
}
