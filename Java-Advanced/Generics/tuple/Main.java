import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        String name = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];

        String[] secondLine = scanner.nextLine().split("\\s+");
        String newName = secondLine[0];
        int litres = Integer.parseInt(secondLine[1]);
        String[] thirdLine = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(thirdLine[0]);
        double otherNumber = Double.parseDouble(thirdLine[1]);

        Tuple<String, String> tuple = new Tuple<>(name, address);
        Tuple<String, Integer> secondTuple = new Tuple<>(newName, litres);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(number, otherNumber);

        System.out.println(tuple.toString());
        System.out.println(secondTuple.toString());
        System.out.println(thirdTuple.toString());
    }
}
