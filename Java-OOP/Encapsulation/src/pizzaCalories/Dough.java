package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    private void setBakingTechnique(String bakingTechnique) {
        validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setFlourType(String flourType) {
        validateFlourType(flourType);
        this.flourType = flourType;
    }

    private void validateWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    private void validateBakingTechnique(String bakingTechnique) {
        List<String> lookUpTable = new ArrayList<>();
        lookUpTable.add("Crispy");
        lookUpTable.add("Chewy");
        lookUpTable.add("Homemade");
        if (!lookUpTable.contains(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void validateFlourType(String flourType) {
        List<String> lookUpTable = new ArrayList<>();
        lookUpTable.add("White");
        lookUpTable.add("Wholegrain");
        if (!lookUpTable.contains(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories() {
        double calories = this.weight * 2;
        if ("White".equals(this.flourType)) {
            calories *= 1.5;
        }
        switch (this.bakingTechnique) {
            case "Crispy":
                calories *= 0.9;
                break;
            case "Chewy":
                calories *= 1.1;
                break;
        }
        return calories;
    }
}
