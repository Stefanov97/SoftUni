package vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double ADDITIONAL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_CONSUMPTION);
    }

    @Override
    public String drive(double distance) {
        String output;
        double fuelNeeded = this.getFuelConsumption() * distance;
        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("Car travelled %s km", format.format(distance));
        } else {
            output = "Car needs refueling";
        }
        return output;
    }
}
