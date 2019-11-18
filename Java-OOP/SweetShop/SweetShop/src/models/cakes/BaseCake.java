package models.cakes;

import models.enums.CakeKind;
import models.enums.CakeType;
import models.cakes.interfaces.Cake;

public abstract class BaseCake implements Cake {
    private String name;
    private String description;
    private double price;
    private int countOfPieces;
    private CakeType cakeType;
    private CakeKind cakeKind;

    protected BaseCake(String name,String description,double price,int countOfPieces,CakeType cakeType,CakeKind cakeKind){
        this.name = name;
        this.description = description;
        this.price = price;
        this.countOfPieces = countOfPieces;
        this.cakeType = cakeType;
        this.cakeKind = cakeKind;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public int getCountOfPieces() {
        return this.countOfPieces;
    }

    @Override
    public CakeType getCakeType() {
        return this.cakeType;
    }

    @Override
    public CakeKind getCakeKind() {
        return this.cakeKind;
    }
}
