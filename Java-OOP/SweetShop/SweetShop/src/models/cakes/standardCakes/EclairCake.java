package models.cakes.standardCakes;

import models.cakes.enums.CakeKind;

public class EclairCake extends StandardCake {
    private static final String NAME = "Eclair cake";
    private static final String DESCRIPTION = "Best eclair cake you've ever tasted!";
    private static final double PRICE = 12;
    private static final int COUNT_OF_PIECES = 7;
    private static final boolean IS_SYRUPY = Boolean.TRUE;
    public EclairCake() {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.ECLAIR, IS_SYRUPY);
    }
}
