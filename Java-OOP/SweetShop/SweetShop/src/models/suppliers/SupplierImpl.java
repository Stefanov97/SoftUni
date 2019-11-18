package models.suppliers;

import models.orders.interfaces.Order;
import models.suppliers.interfaces.Supplier;

import java.util.LinkedHashSet;
import java.util.Set;

public class SupplierImpl implements Supplier {
    private String name;
    private String phoneNumber;
    private Set<Order> orders;
    private double tips;

    public SupplierImpl(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orders = new LinkedHashSet<>();
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
    public Set<Order> getOrders() {
        return this.orders;
    }

    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void addTips(double tips) {
        this.tips += tips;
    }

    @Override
    public double deliver(double tipPercentage) {
        double tips = 0;
        double cashForTheSweetShop = 0;
        for (Order order : this.orders) {
            double tip = order.getPrice() * tipPercentage / 100;
            double cash = order.getPrice();
            cashForTheSweetShop += cash;
            tips += tip;
        }
        this.addTips(tips);
        return cashForTheSweetShop;
    }

    @Override
    public double getTips() {
        return this.tips;
    }

    @Override
    public int getTotalOrders() {
        return this.orders.size();
    }
}
