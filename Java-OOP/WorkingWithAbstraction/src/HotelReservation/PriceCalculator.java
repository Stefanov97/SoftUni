package HotelReservation;

import HotelReservation.Season;

public class PriceCalculator {
    private double pricePerDay;
    private int numberOfDays;
    private Season season;
    private Discount discount;

    public PriceCalculator(double pricePerDay, int numberOfDays, Season season, Discount discount) {
        this.pricePerDay = pricePerDay;
        this.numberOfDays = numberOfDays;
        this.season = season;
        this.discount = discount;
    }

    public double calculate() {
        double result = 0;
        result = (this.pricePerDay * this.season.getMultiplier()) * this.numberOfDays;
        double percentageDiscount = this.discount.getDiscountPercentage() / 100.00;
        result *= 1 - percentageDiscount;

        return result;
    }
}
