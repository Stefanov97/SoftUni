package models.customers;

import models.enums.CakeKind;
import models.sweetShops.interfaces.SweetShop;


public class CorporateCustomer extends BaseCustomer {
    private double discountPercentage;


    public CorporateCustomer(String name, String phoneNumber, double discountPercentage) {
        super(name, phoneNumber);
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return this.discountPercentage;
    }


//    public void order(SweetShop sweetShop,CakeKind cakeKind, int count) {
//        sweetShop.processOrderForCorporativeCustomer(this,cakeKind,count);
//    }



}


