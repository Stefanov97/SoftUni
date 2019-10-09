import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnnonymousThreat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(" +");

        String line = scanner.nextLine();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            result.add(data[i]);
        }

        while (!"3:1".equals(line)) {
            String[] input = line.split(" +");
            String command = input[0];
            int index = Integer.parseInt(input[1]); //0
            int endIndex = Integer.parseInt(input[2]); // 3
            int partitions = Integer.parseInt(input[2]);
            switch (command) {
                case "merge":
                    if (index < 0) {
                        index = 0;
                    }
                    if (endIndex > result.size() - 1) {
                        endIndex = result.size() - 1;
                    }
                    for (int i = index; i < endIndex; i++) {
                        result.set(index, result.get(index) + result.get(index + 1));
                        result.remove(index + 1);
                    }
                    break;
                case "divide":
                    String element = result.get(index);
                    List<String> newList = new ArrayList<>();

                    if (element.length() % partitions == 0) {
                        int portionLength = element.length() / partitions;
                        int count = 0;
                        for (int i = 0; i < partitions; i++) {
                            String concat = "";
                            for (int j = 0; j < portionLength; j++) {
                                char symbol = element.charAt(count);
                                concat += symbol;
                                count++;
                            }
                            newList.add(concat);
                        }
                    } else {
                        int portionLength = element.length() / partitions;
                        int count = 0;
                        for (int i = 0; i < partitions; i++) {
                            String concat = "";

                            if (i == partitions - 1) {
                                for (int j = count; j < element.length(); j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                            } else {
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                            }
                            newList.add(concat);
                        }
                    }
                    result.remove(index);
                    result.addAll(index, newList);
                    break;
            }


            line = scanner.nextLine();
        }
        for (String s : result) {
            System.out.print(s + " ");
        }

    }
}
