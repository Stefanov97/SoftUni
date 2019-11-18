package models.cakes.interfaces;

import models.cakes.enums.CakeKind;
import models.cakes.enums.CakeType;

public interface Cake {
    String getName();
    String getDescription();
    double getPrice();
    int getCountOfPieces();
    CakeType getCakeType();
    CakeKind getCakeKind();
}
