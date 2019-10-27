package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        validateType(toppingType);
        this.toppingType = toppingType;
    }

    private void validateType(String toppingType) {
        List<String> lookUpTable = new ArrayList<>();
        lookUpTable.add("Meat");
        lookUpTable.add("Veggies");
        lookUpTable.add("Cheese");
        lookUpTable.add("Sauce");

        if (!lookUpTable.contains(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void validateWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
    }

    public double calculateCalories() {
        double calories = this.weight * 2;
        switch (this.toppingType) {
            case "Meat":
                calories *= 1.2;
                break;
            case "Veggies":
                calories *= 0.8;
                break;

            case "Cheese":
                calories *= 1.1;
                break;
            case "Sauce":
                calories *= 0.9;
                break;
        }

        return calories;
    }
}
