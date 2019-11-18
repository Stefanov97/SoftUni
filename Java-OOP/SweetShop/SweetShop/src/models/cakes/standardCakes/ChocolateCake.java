package models.cakes.standardCakes;

import models.enums.CakeKind;

public class ChocolateCake extends StandardCake {
    private static final String NAME = "Chocolate cake";
    private static final String DESCRIPTION = "Best chocolate cake you've ever tasted!";
    private static final double PRICE = 10;
    private static final int COUNT_OF_PIECES = 7;
    private static final boolean IS_SYRUPY = Boolean.TRUE;
    public ChocolateCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.CHOCOLATE, IS_SYRUPY);
    }
}
