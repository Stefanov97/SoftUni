import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        String name = firstLine[0] + " " + firstLine[1];
        String address = firstLine[2];
        String town = firstLine[3];

        String[] secondLine = scanner.nextLine().split("\\s+");
        String newName = secondLine[0];
        int litres = Integer.parseInt(secondLine[1]);
        boolean isDrunk = secondLine[2].equals("drunk");
        String[] thirdLine = scanner.nextLine().split("\\s+");
        String otherName = thirdLine[0];
        double accountBalance = Double.parseDouble(thirdLine[1]);
        String bankName = thirdLine[2];

        Threeuple<String, String, String> first = new Threeuple<>();
        first.setItem(name);
        first.setItem2(address);
        first.setItem3(town);

        Threeuple<String, Integer, Boolean> second = new Threeuple<>();
        second.setItem(newName);
        second.setItem2(litres);
        second.setItem3(isDrunk);

        Threeuple<String, Double, String> third = new Threeuple<>();
        third.setItem(otherName);
        third.setItem2(accountBalance);
        third.setItem3(bankName);

        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }
}
