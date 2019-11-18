package models.cakes.weddingCakes;

import models.enums.CakeKind;

public class SmallCake extends WeddingCake {
    private static final String NAME = "Small cake";
    private static final String DESCRIPTION = "Best wedding cake you've ever tasted!";
    private static final double PRICE = 30;
    private static final int COUNT_OF_PIECES = 10;
    private static final int FLOORS_COUNT = 1;
    public SmallCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.SMALL, FLOORS_COUNT);
    }
}
