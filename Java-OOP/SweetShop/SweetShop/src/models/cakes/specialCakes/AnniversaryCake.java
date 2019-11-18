package models.cakes.specialCakes;

import models.enums.CakeKind;

public class AnniversaryCake extends SpecialCake {
    private static final String NAME = "Anniversary cake";
    private static final String DESCRIPTION = "Best anniversary cake you've ever tasted!";
    private static final double PRICE = 29;
    private static final int COUNT_OF_PIECES = 10;
    public AnniversaryCake(String eventName) {
    super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.ANNIVERSARY, eventName);
    }
}
