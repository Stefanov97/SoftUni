package vehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double ADDITIONAL_AMOUNT = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + ADDITIONAL_AMOUNT, tankCapacity);
    }

    @Override
    public String drive(double distance) {
        String output;
        double fuelNeeded = this.getFuelConsumption() * distance;
        if (this.getFuelQuantity() >= fuelNeeded) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            DecimalFormat format = new DecimalFormat("#.##");
            output = String.format("Truck travelled %s km", format.format(distance));
        } else {
            output = "Truck needs refueling";
        }
        return output;
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * 0.95);
    }
}
