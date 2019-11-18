package models.sweetShops;

import models.cakes.enums.CakeKind;
import models.cakes.childCakes.ChildCake;
import models.cakes.interfaces.Cake;
import models.cakes.specialCakes.SpecialCake;
import models.cakes.standardCakes.StandardCake;
import models.cakes.weddingCakes.WeddingCake;
import models.customers.CorporateCustomer;
import models.customers.PrivateCustomer;
import models.orders.OrderImpl;
import models.orders.interfaces.Order;
import models.suppliers.interfaces.Supplier;
import models.sweetShops.interfaces.SweetShop;
import models.vouchers.interfaces.Voucher;
import repositories.CakeCatalogImpl;
import repositories.interfaces.CakeCatalog;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SweetShopImpl implements SweetShop {
    private String name;
    private String address;
    private String phone;
    private int indexOfSupliers = 0;
    private List<Supplier> suppliers;
    private double cashRegister;
    private CakeCatalog catalog;
    private Map<String,Integer> soldCakes;

    public SweetShopImpl(String name, String address, String phone, List<Supplier> suppliers) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.suppliers = suppliers;
        this.cashRegister = 0;
        this.catalog = new CakeCatalogImpl();
        this.soldCakes = new LinkedHashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }

    public double getCashRegister() {
        return this.cashRegister;
    }

    @Override
    public Map<String, Integer> getSoldCakes() {
        return this.soldCakes;
    }

    @Override
    public CakeCatalog getCatalog() {
        return this.catalog;
    }

    @Override
    public List<Supplier> getSuppliers() {
        return this.suppliers;
    }

    @Override
    public void processOrderForCorporativeCustomer(CorporateCustomer customer, CakeKind cakeKind, int count) {
        List<Cake> orderedCakes = getCakes(cakeKind, count);
        double discountPercentage = customer.getDiscountPercentage();
        double price = orderedCakes.stream().mapToDouble(Cake::getPrice).sum();
        double priceAfterDiscount = price - (price * discountPercentage / 100.0);
        Order order = new OrderImpl(customer, priceAfterDiscount, "Studentski", orderedCakes, "Today at 5 pm");
        Supplier supplier = this.suppliers.get(indexOfSupliers++ % this.suppliers.size());
        double tipPercentage = 5;
        supplier.addOrder(order);
        this.cashRegister += supplier.deliver(tipPercentage);
        customer.payOrder(priceAfterDiscount);
    }

    @Override
    public void processOrderForPrivateCustomer(PrivateCustomer customer, CakeKind cakeKind, int count) {
        List<Cake> orderedCakes = getCakes(cakeKind, count);
        List<Voucher> vouchers = customer.getVouchers();
        double price = orderedCakes.stream().mapToDouble(Cake::getPrice).sum();
        double discount = vouchers.stream().mapToDouble(Voucher::getValue).sum();
        double priceAfterDiscount = price - discount;
        Order order = new OrderImpl(customer, priceAfterDiscount, "Studentski", orderedCakes, "Today at 5 pm");
        Supplier supplier = this.suppliers.get(indexOfSupliers++ % this.suppliers.size());
        double tipPercentage = 2;
        supplier.addOrder(order);
        this.cashRegister += supplier.deliver(tipPercentage);
        customer.payOrder(priceAfterDiscount);
    }

    private List<Cake> getCakes(CakeKind cakeKind, int count) {
        List<Cake> cakes = new ArrayList<>();
        Cake cake = null;
        while (count-- > 0) {
            List<StandardCake> standardCakes = this.catalog.getStandardCakes();
            List<WeddingCake> weddingCakes = this.catalog.getWeddingCakes();
            List<SpecialCake> specialCakes = this.catalog.getSpecialCakes();
            List<ChildCake> childCakes = this.catalog.getChildCakes();
            switch (cakeKind) {
                case CHOCOLATE:
                    cake = standardCakes.stream().filter(c -> c.getName().equals("Chocolate cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Standard cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeStandardCake(cake.getName());
                    }
                    break;
                case COOKIE:
                    cake = standardCakes.stream().filter(c -> c.getName().equals("Cookie cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Standard cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeStandardCake(cake.getName());
                    }
                    break;
                case ECLAIR:
                    cake = standardCakes.stream().filter(c -> c.getName().equals("Eclair cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Standard cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeStandardCake(cake.getName());
                    }
                    break;
                case FRUIT:
                    cake = standardCakes.stream().filter(c -> c.getName().equals("Fruit cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Standard cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeStandardCake(cake.getName());
                    }
                    break;
                case SMALL:
                    cake = weddingCakes.stream().filter(c -> c.getName().equals("Small cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Wedding cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeWeddingCake(cake.getName());
                    }
                case MEDIUM:
                    cake = weddingCakes.stream().filter(c -> c.getName().equals("Medium cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Wedding cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeWeddingCake(cake.getName());
                    }
                    break;
                case LARGE:
                    cake = weddingCakes.stream().filter(c -> c.getName().equals("Large cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Wedding cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeWeddingCake(cake.getName());
                    }
                    break;
                case ANNIVERSARY:
                    cake = specialCakes.stream().filter(c -> c.getName().equals("Anniversary cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Special cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeSpecialCake(cake.getName());
                    }
                    break;
                case ADVERTISING:
                    cake = specialCakes.stream().filter(c -> c.getName().equals("Advertising cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Special cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeSpecialCake(cake.getName());
                    }
                    break;
                case FIRM:
                    cake = specialCakes.stream().filter(c -> c.getName().equals("Firm cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Special cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeSpecialCake(cake.getName());
                    }
                    break;
                case BAPTISM:
                    cake = childCakes.stream().filter(c -> c.getName().equals("Baptism cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Child cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeChildCake(cake.getName());
                    }
                    break;
                case BIRTHDAY:
                    cake = childCakes.stream().filter(c -> c.getName().equals("Birthday cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Child cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeChildCake(cake.getName());
                    }
                    break;
                case PURVEYOR:
                    cake = childCakes.stream().filter(c -> c.getName().equals("Purveyor cake")).findFirst().orElse(null);
                    if (cake != null) {
                        String name = "Child cake";
                        if(!this.soldCakes.containsKey(name)){
                            this.soldCakes.put(name,1);
                        }else {
                            this.soldCakes.put(name,this.soldCakes.get(name) + 1);
                        }
                        this.catalog.removeChildCake(cake.getName());
                    }
                    break;
            }
            if (cake != null) {
                cakes.add(cake);
            }
        }
        return cakes;
    }

}
