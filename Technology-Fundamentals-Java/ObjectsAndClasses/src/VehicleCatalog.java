import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!"End".equals(line)) {
            String[] tokens = line.split(" +");
            String type = tokens[0];
            String model = tokens[1];
            String color = tokens[2];
            int horsePower = Integer.parseInt(tokens[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsePower);
            vehicles.add(vehicle);


            line = scanner.nextLine();
        }
        String input = scanner.nextLine();
        while (!"Close the Catalogue".equals(input)) {
            String model = input;
            for (int i = 0; i < vehicles.size(); i++) {
                if (vehicles.get(i).getModel().equals(model)) {
                    if (vehicles.get(i).getType().equals("car")) {
                        System.out.println("Type: Car");
                        System.out.printf("Model: %s", vehicles.get(i).getModel()).println();
                        System.out.printf("Color: %s", vehicles.get(i).getColor()).println();
                        System.out.printf("Horsepower: %d", vehicles.get(i).getHorsePower()).println();
                    } else {
                        System.out.println("Type: Truck");
                        System.out.printf("Model: %s", vehicles.get(i).getModel()).println();
                        System.out.printf("Color: %s", vehicles.get(i).getColor()).println();
                        System.out.printf("Horsepower: %d", vehicles.get(i).getHorsePower()).println();
                    }
                }
            }

            input = scanner.nextLine();
        }
        int carCount = 0;
        int truckCount = 0;
        int hpCars = 0;
        int hpTrucks = 0;
        double avgHpCars = 0;
        double avgHpTrucks = 0;


        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getType().equals("car")) {
                carCount++;
                hpCars += vehicles.get(i).getHorsePower();

            } else {
                truckCount++;
                hpTrucks += vehicles.get(i).getHorsePower();

            }
        }
        if (carCount != 0) {
            avgHpCars = hpCars * 1.0 / carCount;

        }
        if (truckCount != 0) {
            avgHpTrucks = hpTrucks * 1.0 / truckCount;
        }
        System.out.printf("Cars have average horsepower of: %.2f.", avgHpCars).println();
        System.out.printf("Trucks have average horsepower of: %.2f.", avgHpTrucks);
    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        Vehicle(String type, String model, String color, int horsePower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
