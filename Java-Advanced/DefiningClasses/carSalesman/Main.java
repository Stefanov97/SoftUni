import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> enginesMap = new LinkedHashMap<>();
        List<Car> carsMap = new ArrayList<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String engineModel = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(engineModel, power);
            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    String displacement = tokens[2];
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = tokens[2];
                    engine.setEfficiency(efficiency);
                }
            } else if (tokens.length == 4) {
                String displacement = tokens[2];
                String efficiency = tokens[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }
            enginesMap.put(engineModel, engine);
        }

        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            String engineToGet = tokens[1];
            Engine engine = enginesMap.get(engineToGet);
            Car car = new Car(carModel, engine);

            if (tokens.length == 3) {
                if (Character.isDigit(tokens[2].charAt(0))) {
                    String weight = tokens[2];
                    car.setWeight(weight);
                } else {
                    String color = tokens[2];
                    car.setColor(color);
                }
            } else if (tokens.length == 4) {
                String weight = tokens[2];
                String color = tokens[3];
                car.setWeight(weight);
                car.setColor(color);
            }

            carsMap.add(car);

        }
        carsMap.forEach(car -> {

            System.out.println(car.getModel() + ":");

            Engine engine = car.getEngine();
            System.out.println(engine.getModel() + ":");

            System.out.println("Power: " + engine.getPower());
            System.out.println("Displacement: " + engine.getDisplacement());
            System.out.println("Efficiency: " + engine.getEfficiency());
            System.out.println("Weight: " + car.getWeight());
            System.out.println("Color: " + car.getColor());
        });
    }
}
