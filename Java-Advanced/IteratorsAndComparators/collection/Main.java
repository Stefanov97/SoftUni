import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        ListyIterator list = new ListyIterator(new ArrayList<>());
        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            switch (command) {
                case "Create":
                    if (tokens.length > 1) {
                        List<String> toAdd = new ArrayList<>();
                        for (int i = 1; i < tokens.length; i++) {
                            toAdd.add(tokens[i]);
                        }
                        list = new ListyIterator(toAdd);
                    }
                    break;
                case "Move":
                    System.out.println(list.Move());
                    break;
                case "Print":
                    try {
                        list.Print();
                    } catch (IllegalAccessException exp) {
                        System.out.println(exp.getMessage());
                    }

                    break;
                case "HasNext":
                    System.out.println(list.HasNext());
                    break;
                case "PrintAll":
                    try {
                        list.PrintAll();
                    } catch (IllegalAccessException exp) {
                        System.out.println(exp.getMessage());
                    }
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
