package restaurant;

import java.math.BigDecimal;

public class Cake extends Dessert {
    private static final double CAKE_GRAMS = 250;
    private static final double CAKE_CALORIES = 1000;
    private static final BigDecimal CAKE_PRICE = new BigDecimal(5);

    public Cake(String name) {
        super(name, CAKE_PRICE, CAKE_GRAMS, CAKE_CALORIES);
    }

    @Override
    public BigDecimal getPrice() {
        return CAKE_PRICE;
    }

    @Override
    public double getGrams() {
        return CAKE_GRAMS;
    }

    public double getCalories() {
        return CAKE_CALORIES;
    }
}
