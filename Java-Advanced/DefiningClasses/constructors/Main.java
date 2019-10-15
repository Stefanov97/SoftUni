import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String make = tokens[0];
            if (tokens.length == 1) {
                Car car = new Car(make);
                cars.add(car);
            } else {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(make, model, horsePower);
                cars.add(car);

            }

        }
        cars.forEach(Car::getInfo);
    }
}
