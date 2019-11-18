package models.customers.interfaces;

import models.cakes.enums.CakeKind;
import models.sweetShops.interfaces.SweetShop;

public interface Customer {
    String getName();
    String getPhoneNumber();
    void order(SweetShop sweetShop, CakeKind cakeKind, int count);
    double getTotalSpentForCakes();
    void  payOrder(double price);
}
