package models.cakes.childCakes;

import models.cakes.BaseCake;
import models.enums.CakeKind;
import models.enums.CakeType;

public abstract class ChildCake extends BaseCake {
    private String childName;
    protected ChildCake(String name, String description, double price, int countOfPieces, CakeKind cakeKind,String childName) {
        super(name, description, price, countOfPieces, CakeType.CHILD, cakeKind);
        this.childName = childName;
    }
}
