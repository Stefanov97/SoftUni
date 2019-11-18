package models.cakes.childCakes;

import models.cakes.enums.CakeKind;

public class PurveyorCake extends ChildCake {
    private static final String NAME = "Purveyor cake";
    private static final String DESCRIPTION = "Best purveyor cake you've ever tasted!";
    private static final double PRICE = 17.56;
    private static final int COUNT_OF_PIECES = 5;
    public PurveyorCake(String childName) {
        super(NAME, DESCRIPTION, PRICE, COUNT_OF_PIECES, CakeKind.PURVEYOR, childName);
    }
}
