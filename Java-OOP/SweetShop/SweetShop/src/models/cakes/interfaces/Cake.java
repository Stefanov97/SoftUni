package models.cakes.interfaces;

import models.enums.CakeKind;
import models.enums.CakeType;

public interface Cake {
    String getName();
    String getDescription();
    double getPrice();
    int getCountOfPieces();
    CakeType getCakeType();
    CakeKind getCakeKind();
}
