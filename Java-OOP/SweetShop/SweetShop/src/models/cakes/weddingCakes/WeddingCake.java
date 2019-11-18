package models.cakes.weddingCakes;

import models.cakes.BaseCake;
import models.enums.CakeKind;
import models.enums.CakeType;

public abstract class WeddingCake extends BaseCake {
    private int floorsCount;
    protected WeddingCake(String name, String description, double price, int countOfPieces, CakeKind cakeKind, int floorsCount) {
        super(name, description, price, countOfPieces, CakeType.WEDDING, cakeKind);
        this.floorsCount = floorsCount;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    protected void setFloorsCount(int floorsCount) {
        this.floorsCount = floorsCount;
    }
}
