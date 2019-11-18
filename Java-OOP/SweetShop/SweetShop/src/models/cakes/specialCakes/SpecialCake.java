package models.cakes.specialCakes;

import models.cakes.BaseCake;
import models.enums.CakeKind;
import models.enums.CakeType;

public abstract class SpecialCake extends BaseCake {
    private String eventName;
    protected SpecialCake(String name, String description, double price, int countOfPieces, CakeKind cakeKind, String eventName) {
        super(name, description, price, countOfPieces, CakeType.SPECIAL, cakeKind);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    protected void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
