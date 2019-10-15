public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Km;
    private int distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostFor1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Km = fuelCostFor1Km;
    }

    public double getFuelCostFor1Km() {
        return fuelCostFor1Km;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public boolean CanTravellThatDistance(int distance) {

        double totalFuelNeeded = distance * this.fuelCostFor1Km;
        if (this.fuelAmount < totalFuelNeeded) {
            return false;
        }

        return true;
    }

    public double reduceFuel(double totalFuelNeeded) {
        return this.fuelAmount -= totalFuelNeeded;
    }

    public int increaseDistance(int distance) {
        return this.distanceTravelled += distance;
    }
}
