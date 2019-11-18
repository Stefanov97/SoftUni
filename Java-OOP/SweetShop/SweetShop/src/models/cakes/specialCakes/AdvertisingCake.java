package models.cakes.specialCakes;

import models.cakes.enums.CakeKind;

public class AdvertisingCake extends SpecialCake {
    private static final String NAME = "Advertising cake";
    private static final String DESCRIPTION = "Best advertising cake you've ever tasted!";
    private static final double PRICE = 19;
    private static final int COUNT_OF_PIECES = 10;
    public AdvertisingCake(String eventName) {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.ADVERTISING, eventName);
    }
}
