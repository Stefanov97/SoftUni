package models.cakes.specialCakes;

import models.cakes.enums.CakeKind;

public class FirmCake extends SpecialCake {
    private static final String NAME = "Firm cake";
    private static final String DESCRIPTION = "Best firm cake you've ever tasted!";
    private static final double PRICE = 36;
    private static final int COUNT_OF_PIECES = 10;
    public FirmCake(String eventName) {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.FIRM, eventName);
    }
}
