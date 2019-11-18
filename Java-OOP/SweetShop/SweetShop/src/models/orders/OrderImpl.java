package models.orders;

import models.cakes.interfaces.Cake;
import models.customers.interfaces.Customer;
import models.orders.interfaces.Order;

import java.util.List;

public class OrderImpl implements Order {
    private Customer customer;
    private double price;
    private String address;
    private List<Cake> orderedCakes;
    private String deliveryTimeAndDate;

    public OrderImpl(Customer customer, double price, String address, List<Cake> orderedCakes, String deliveryTimeAndDate) {
        this.customer = customer;
        this.price = price;
        this.address = address;
        this.orderedCakes = orderedCakes;
        this.deliveryTimeAndDate = deliveryTimeAndDate;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public List<Cake> getOrderedCakes() {
        return this.orderedCakes;
    }

    @Override
    public String getDeliveryTimeAndDate() {
        return this.deliveryTimeAndDate;
    }
}
