import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalMoney = Double.parseDouble(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        double lightsabersPrice = Double.parseDouble(scanner.nextLine());
        double robesPrice = Double.parseDouble(scanner.nextLine());
        double beltsPrice = Double.parseDouble(scanner.nextLine());

        double finalSabers = lightsabersPrice * Math.ceil(studentsCount + (studentsCount * 0.1));
        double finalRobes = robesPrice * studentsCount;
        double finalBelts = beltsPrice * (studentsCount - ((studentsCount / 6)));

        double price = finalBelts + finalRobes + finalSabers;

        if (totalMoney >= price) {
            System.out.printf("The money is enough - it would cost %.2flv.", price);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", Math.abs(price - totalMoney));
        }
    }
}
