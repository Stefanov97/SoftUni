
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostFor1Km = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1Km);
            carsMap.put(model, car);
        }
        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String model = tokens[1];
            int distance = Integer.parseInt(tokens[2]);


            Car currentCar = carsMap.get(model);

            double totalFuelNeeded = currentCar.getFuelCostFor1Km() * distance;
            if (currentCar.CanTravellThatDistance(distance)) {
                currentCar.reduceFuel(totalFuelNeeded);
                currentCar.increaseDistance(distance);

            } else {
                System.out.println("Insufficient fuel for the drive");
            }


            line = scanner.nextLine();
        }

        carsMap.forEach((k, v) -> {
            System.out.println(String.format("%s %.2f %d", k, v.getFuelAmount(), v.getDistanceTravelled()));
        });
    }
}
