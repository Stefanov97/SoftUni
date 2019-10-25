package HotelReservation;

public enum Discount {
    VIP(20),
    SECOND_VISIT(10),
    NONE(0);
    private int discountPercentage;

    Discount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }
}
