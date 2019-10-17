import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String line = scanner.nextLine();
//Max - Prints the maximum element in the list
//	Min - Prints the minimum element in the list
//	Print - Prints all elements in the list, each on a separate line
//END - stops the reading of commands

        while (!"END".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String element = tokens[1];
                    list.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(tokens[1]);
                    list.remove(index);

                    break;
                case "Contains":
                    System.out.println(list.contains(tokens[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));

                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(tokens[1]));

                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;

                case "Print":
                    //list.printElements();
                    // CustomList.print(list);
                    list.forEach(System.out::println);
                    break;

                case "Sort":
                    Sorter.sort(list);
                    break;
            }


            line = scanner.nextLine();
        }

    }
}
