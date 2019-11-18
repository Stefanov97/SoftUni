package models.sweetShops.interfaces;

import models.customers.interfaces.Customer;
import models.enums.CakeKind;
import models.customers.CorporateCustomer;
import models.customers.PrivateCustomer;
import models.suppliers.interfaces.Supplier;
import models.catalogs.interfaces.CakeCatalog;

import java.util.List;
import java.util.Map;

public interface SweetShop {
    String getName();

    String getAddress();

    String getPhone();
    double getCashRegister();
    Map<String,Integer> getSoldCakes();
    List<Supplier> getSuppliers();
    void processOrder(Customer customer, CakeKind cakeKind, int count);
    CakeCatalog getCatalog();
}
