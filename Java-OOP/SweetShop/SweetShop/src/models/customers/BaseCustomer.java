package models.customers;

import models.customers.interfaces.Customer;
import models.enums.CakeKind;
import models.sweetShops.interfaces.SweetShop;

public abstract class BaseCustomer implements Customer {
    private String name;
    private String phoneNumber;
    private double totalSpentForCakes;

    protected BaseCustomer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.totalSpentForCakes = 0;
    }

    @Override
    public double getTotalSpentForCakes() {
        return this.totalSpentForCakes;
    }

    @Override
    public void payOrder(double price) {
        this.totalSpentForCakes += price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public void order(SweetShop sweetShop, CakeKind cakeKind, int count) {
        sweetShop.processOrder(this,cakeKind,count);
    }
}
