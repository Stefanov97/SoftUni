package models.cakes.standardCakes;

import models.cakes.BaseCake;
import models.enums.CakeKind;
import models.enums.CakeType;

public abstract class StandardCake extends BaseCake {
    private boolean isSyrupy;
    protected StandardCake(String name, String description, double price, int countOfPieces, CakeKind cakeKind, boolean isSyrupy) {
        super(name, description, price, countOfPieces, CakeType.STANDARD, cakeKind);
        this.setSyrupy(isSyrupy);
    }

    public boolean isSyrupy() {
        return isSyrupy;
    }

    protected void setSyrupy(Boolean isSyrupy) {
       this.isSyrupy = isSyrupy;
    }
}
