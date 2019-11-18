package core;

import core.interfaces.Controller;
import models.cakes.enums.CakeKind;
import models.cakes.enums.CakeType;
import models.cakes.childCakes.ChildCake;
import models.cakes.specialCakes.SpecialCake;
import models.cakes.standardCakes.StandardCake;
import models.cakes.weddingCakes.WeddingCake;
import models.customers.interfaces.Customer;
import models.suppliers.interfaces.Supplier;
import models.sweetShops.interfaces.SweetShop;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private SweetShop sweetShop;
    private List<Customer> customers;

    public ControllerImpl(SweetShop sweetShop, List<Customer> customers) {
        this.sweetShop = sweetShop;
        this.customers = customers;
    }


    @Override
    public void processOrders() {
        CakeKind[] cakeKindValues = CakeKind.values();
        int index = 0;
        for (Customer customer : this.customers) {
            customer.order(this.sweetShop, cakeKindValues[index++ % cakeKindValues.length], 2);
        }
    }

    @Override
    public String getCakesBeforeOrders() {
        StringBuilder sb = new StringBuilder();
        sb.append("### Cakes BEFORE orders:").append(System.lineSeparator());
        sb.append(this.getCakesToString()).append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override
    public String getCakesAfterOrders() {
        StringBuilder sb = new StringBuilder();
        sb.append("### Cakes AFTER orders:").append(System.lineSeparator());
        sb.append(this.getCakesToString()).append(System.lineSeparator());

        return sb.toString().trim();
    }

    @Override
    public String getCashRegister() {
        return String.format("SWEET SHOP TOTAL PROFIT: %.2f", this.sweetShop.getCashRegister());
    }

    @Override
    public String getSuppliersOrderedByTips() {
        StringBuilder sb = new StringBuilder();
        List<Supplier> suppliers = this.sweetShop.getSuppliers().stream().sorted((f, s) -> Double.compare(s.getTips(), f.getTips())).collect(Collectors.toList());
        sb.append("### Suppliers:").append(System.lineSeparator());
        suppliers.forEach(s -> sb.append(String.format("%s - Tips: %.2f", s.getName(), s.getTips())).append(System.lineSeparator()));
        return sb.toString().trim();
    }

    @Override
    public String getTheBestSellingCake() {
        String bestSellingCake="";

        Map.Entry<String, Integer> sorted = this.sweetShop.getSoldCakes().entrySet().stream().sorted((f, s) -> s.getValue() - f.getValue()).findFirst().orElse(null);
        bestSellingCake = sorted.getKey();
        String result =String.format(String.format("### Best Selling Cake: %s",bestSellingCake));
        return result;
    }

    @Override
    public String getTheSupplierWithMaxOrders() {
        List<Supplier> suppliers = this.sweetShop.getSuppliers().stream().sorted((f, s) -> s.getTotalOrders() - f.getTotalOrders()).collect(Collectors.toList());
        Supplier bestSupplier = suppliers.get(0);
        String result = String.format("Name: %s - Total orders %d",bestSupplier.getName(),bestSupplier.getTotalOrders());
        return result;
    }

    @Override
    public String getTheCustomerWithHighestBill() {
        List<Customer> customers = this.customers.stream().sorted((f, s) -> Double.compare(s.getTotalSpentForCakes(), f.getTotalSpentForCakes())).collect(Collectors.toList());
        Customer customerWithHighestBill = customers.get(0);
        String result = String.format("%s - Total money spent for cakes - %.2f",customerWithHighestBill.getName(),customerWithHighestBill.getTotalSpentForCakes());

        return result;
    }

    private String getCakesToString() {
        StringBuilder sb = new StringBuilder();
        int cakeQuantity = this.sweetShop.getCatalog().getChildCakes().size() + this.sweetShop.getCatalog().getSpecialCakes().size() + this.sweetShop.getCatalog().getStandardCakes().size() + this.sweetShop.getCatalog().getWeddingCakes().size();
        sb.append(String.format("Cakes quantity: %d", cakeQuantity)).append(System.lineSeparator());
        sb.append("Standard cakes:").append(System.lineSeparator());
        for (StandardCake standardCake : this.sweetShop.getCatalog().getStandardCakes()) {
            CakeType type = standardCake.getCakeType();
            String cakeType = type.toString().substring(0, 1) + type.toString().substring(1).toLowerCase();
            CakeKind kind = standardCake.getCakeKind();
            String cakeKind = kind.toString().substring(0, 1) + kind.toString().substring(1).toLowerCase();
            sb.append(String.format("Type: %s, Kind: %s ", cakeType, cakeKind)).append(System.lineSeparator());
        }
        sb.append("Child cakes:").append(System.lineSeparator());
        for (ChildCake childCake : this.sweetShop.getCatalog().getChildCakes()) {
            CakeType type = childCake.getCakeType();
            String cakeType = type.toString().substring(0, 1) + type.toString().substring(1).toLowerCase();
            CakeKind kind = childCake.getCakeKind();
            String cakeKind = kind.toString().substring(0, 1) + kind.toString().substring(1).toLowerCase();
            sb.append(String.format("Type: %s, Kind: %s ", cakeType, cakeKind)).append(System.lineSeparator());
        }

        sb.append("Special cakes:").append(System.lineSeparator());
        for (SpecialCake specialCake : this.sweetShop.getCatalog().getSpecialCakes()) {
            CakeType type = specialCake.getCakeType();
            String cakeType = type.toString().substring(0, 1) + type.toString().substring(1).toLowerCase();
            CakeKind kind = specialCake.getCakeKind();
            String cakeKind = kind.toString().substring(0, 1) + kind.toString().substring(1).toLowerCase();
            sb.append(String.format("Type: %s, Kind: %s ", cakeType, cakeKind)).append(System.lineSeparator());
        }

        sb.append("Wedding cakes:").append(System.lineSeparator());
        for (WeddingCake weddingCake : this.sweetShop.getCatalog().getWeddingCakes()) {
            CakeType type = weddingCake.getCakeType();
            String cakeType = type.toString().substring(0, 1) + type.toString().substring(1).toLowerCase();
            CakeKind kind = weddingCake.getCakeKind();
            String cakeKind = kind.toString().substring(0, 1) + kind.toString().substring(1).toLowerCase();
            sb.append(String.format("Type: %s, Kind: %s ", cakeType, cakeKind)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
