package vehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle car = null;
        Vehicle truck = null;
        Bus bus = null;

        try {
            car = produceCar(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            truck = produceTruck(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {

            bus = produceBus(scanner.nextLine().split("\\s+"));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }


        int numberOfLines = Integer.parseInt(scanner.nextLine());

        while (numberOfLines-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            switch (tokens[0]) {
                case "Drive":
                    if (tokens[1].equals("Car")) {
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    } else if (tokens[1].equals("Truck")) {
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    } else {
                        System.out.println(bus.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "DriveEmpty":
                    System.out.println(bus.driveEmpty(Double.parseDouble(tokens[2])));
                    break;
                case "Refuel":
                    try {
                        if (tokens[1].equals("Car")) {
                            car.refuel(Double.parseDouble(tokens[2]));
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(Double.parseDouble(tokens[2]));
                        } else {
                            bus.refuel(Double.parseDouble(tokens[2]));
                        }
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static Bus produceBus(String[] tokens) {
        return new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }


    private static Vehicle produceTruck(String[] tokens) {
        return new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }

    private static Vehicle produceCar(String[] tokens) {
        return new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
    }
}
