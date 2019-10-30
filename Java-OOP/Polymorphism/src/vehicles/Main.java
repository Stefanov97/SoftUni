package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle car = produceCar(scanner.nextLine().split("\\s+"));
        Vehicle truck = produceTruck(scanner.nextLine().split("\\s+"));

        int numberOfLines = Integer.parseInt(scanner.nextLine());

        while (numberOfLines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    } else {
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "Refuel":
                    if (tokens[1].equals("Car")) {
                        car.refuel(Double.parseDouble(tokens[2]));
                    } else {
                        truck.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }

    private static Vehicle produceTruck(String[] tokens) {
        return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
    }

    private static Vehicle produceCar(String[] tokens) {
        return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
    }
}
