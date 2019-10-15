
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double firstTirePressure = Double.parseDouble(tokens[5]);
            int firstTireAge = Integer.parseInt(tokens[6]);

            double secondTirePressure = Double.parseDouble(tokens[7]);
            int secondTireAge = Integer.parseInt(tokens[8]);

            double thirdTirePressure = Double.parseDouble(tokens[9]);
            int thirdTireAge = Integer.parseInt(tokens[10]);

            double fourthTirePressure = Double.parseDouble(tokens[11]);
            int fourthTireAge = Integer.parseInt(tokens[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            List<Tire> tires = new ArrayList<>();
            Tire firstTire = new Tire(firstTirePressure, firstTireAge);
            tires.add(firstTire);

            Tire secondTire = new Tire(secondTirePressure, secondTireAge);
            tires.add(secondTire);

            Tire thirdTire = new Tire(thirdTirePressure, thirdTireAge);
            tires.add(thirdTire);

            Tire fourthTire = new Tire(fourthTirePressure, fourthTireAge);
            tires.add(fourthTire);

            Car car = new Car(model, engine, cargo, tires);
            carsMap.put(model, car);


        }
        Predicate<Cargo> isFragile = cargo -> cargo.getCargoType().equals("fragile");
        Predicate<Cargo> isFlamable = cargo -> cargo.getCargoType().equals("flamable");
        String line = scanner.nextLine();
        List<String> validModels = new ArrayList<>();
        switch (line) {
            case "fragile":
                carsMap.entrySet().stream().forEach(entry -> {
                    Car car = entry.getValue();
                    boolean isValidTire = false;
                    for (Tire tire : car.getTires()) {
                        if (tire.getTirePressure() < 1) {
                            isValidTire = true;
                            break;
                        }
                    }
                    if (isValidTire && car.getCargo().getCargoType().equals("fragile")) {
                        validModels.add(car.getModel());
                    }

                });
                break;

            case "flamable":
                carsMap.entrySet().stream().forEach(entry -> {
                    Car car = entry.getValue();
                    if (car.getCargo().getCargoType().equals("flamable") && car.getEngine().getEnginePower() > 250) {
                        validModels.add(car.getModel());
                    }
                });

                break;
        }
        validModels.forEach(model -> System.out.println(model));

    }
}
