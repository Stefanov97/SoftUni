package models.suppliers.interfaces;

import models.orders.interfaces.Order;

import java.util.Set;

public interface Supplier {
    String getName();
    String getPhoneNumber();
    Set<Order> getOrders();
    void addOrder(Order order);
    void addTips(double tips);
    double deliver(double tipPercentage);
    double getTips();
    int getTotalOrders();
}
