import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> cars = new HashSet<>();

        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String car = tokens[1];

            switch (command) {
                case "IN":
                    cars.add(car);
                    break;
                case "OUT":
                    cars.remove(car);
                    break;
            }
            input = scanner.nextLine();
        }
        if (!cars.isEmpty()) {
            cars.forEach(e -> System.out.println(e));
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
