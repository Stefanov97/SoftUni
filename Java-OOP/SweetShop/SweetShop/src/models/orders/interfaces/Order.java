package models.orders.interfaces;

import models.cakes.interfaces.Cake;
import models.customers.interfaces.Customer;

import java.util.List;

public interface Order {
    Customer getCustomer();
    double getPrice();
    String getAddress();
    List<Cake> getOrderedCakes();
    String getDeliveryTimeAndDate();
}
