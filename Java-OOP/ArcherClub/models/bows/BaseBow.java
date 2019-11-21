package models.bows;

public abstract class BaseBow implements Bow {
    private String manufacturer;
    private double weight;
    private int strength;

    protected BaseBow(String manufacturer, double weight, int strength) {
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.strength = strength;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }
}
