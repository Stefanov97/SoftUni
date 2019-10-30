package vehiclesExtension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    public static final double ADDITIONAL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }


    @Override
    public String drive(double distance) {
        String output;
        this.setFuelConsumption(this.getFuelConsumption() + ADDITIONAL_CONSUMPTION);
        double fuelNeeded = this.getFuelConsumption() * distance;
        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("Bus travelled %s km", format.format(distance));
        } else {
            output = "Bus needs refueling";
        }
        return output;
    }

    public String driveEmpty(double distance) {
        String output;
        double fuelNeeded = this.getFuelConsumption() * distance;
        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("Bus travelled %s km", format.format(distance));
        } else {
            output = "Bus needs refueling";
        }
        return output;
    }
}
