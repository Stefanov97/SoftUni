package models.cakes.standardCakes;

import models.enums.CakeKind;

public class CookieCake extends StandardCake {
    private static final String NAME = "Cookie cake";
    private static final String DESCRIPTION = "Best cookie cake you've ever tasted!";
    private static final double PRICE = 15;
    private static final int COUNT_OF_PIECES = 7;
    private static final boolean IS_SYRUPY = Boolean.FALSE;
    public CookieCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.COOKIE, IS_SYRUPY);
    }
}
