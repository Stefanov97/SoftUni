package models.cakes.standardCakes;

import models.enums.CakeKind;

public class FruitCake extends StandardCake {
    private static final String NAME = "Fruit cake";
    private static final String DESCRIPTION = "Best fruit cake you've ever tasted!";
    private static final double PRICE = 25;
    private static final int COUNT_OF_PIECES = 7;
    private static final boolean IS_SYRUPY = Boolean.FALSE;
    public FruitCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.FRUIT, IS_SYRUPY);
    }
}
