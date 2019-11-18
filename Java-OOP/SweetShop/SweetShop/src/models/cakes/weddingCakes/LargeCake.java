package models.cakes.weddingCakes;

import models.enums.CakeKind;

public class LargeCake extends WeddingCake {
    private static final String NAME = "Large cake";
    private static final String DESCRIPTION = "Best wedding cake you've ever tasted!";
    private static final double PRICE = 50;
    private static final int COUNT_OF_PIECES = 20;
    private static final int FLOORS_COUNT = 3;
    public LargeCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.LARGE, FLOORS_COUNT);
    }
}
