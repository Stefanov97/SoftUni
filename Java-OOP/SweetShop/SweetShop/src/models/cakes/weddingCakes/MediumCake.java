package models.cakes.weddingCakes;

import models.enums.CakeKind;

public class MediumCake extends WeddingCake {
    private static final String NAME = "Medium cake";
    private static final String DESCRIPTION = "Best wedding cake you've ever tasted!";
    private static final double PRICE = 40;
    private static final int COUNT_OF_PIECES = 15;
    private static final int FLOORS_COUNT = 2;
    public MediumCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.MEDIUM, FLOORS_COUNT);
    }
}
