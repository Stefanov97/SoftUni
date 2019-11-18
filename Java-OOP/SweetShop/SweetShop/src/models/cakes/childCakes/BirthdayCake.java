package models.cakes.childCakes;

import models.cakes.enums.CakeKind;

public class BirthdayCake extends ChildCake {
    private static final String NAME = "Birthday cake";
    private static final String DESCRIPTION = "Best birthday cake you've ever tasted!";
    private static final double PRICE = 18;
    private static final int COUNT_OF_PIECES = 5;
    public BirthdayCake(String childName) {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.BIRTHDAY, childName);
    }
}
