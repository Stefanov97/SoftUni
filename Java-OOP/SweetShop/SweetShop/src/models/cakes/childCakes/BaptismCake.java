package models.cakes.childCakes;

import models.enums.CakeKind;

public class BaptismCake extends ChildCake {
    private static final String NAME = "Baptism cake";
    private static final String DESCRIPTION = "Best baptism cake you've ever tasted!";
    private static final double PRICE = 16;
    private static final int COUNT_OF_PIECES = 5;
    public BaptismCake(String childName) {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.BAPTISM, childName);
    }
}
