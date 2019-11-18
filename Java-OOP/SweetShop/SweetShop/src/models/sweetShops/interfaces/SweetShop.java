package models.sweetShops.interfaces;

import models.cakes.enums.CakeKind;
import models.customers.CorporateCustomer;
import models.customers.PrivateCustomer;
import models.suppliers.interfaces.Supplier;
import repositories.interfaces.CakeCatalog;

import java.util.List;
import java.util.Map;

public interface SweetShop {
    String getName();

    String getAddress();

    String getPhone();
    double getCashRegister();
    Map<String,Integer> getSoldCakes();

    List<Supplier> getSuppliers();

    void processOrderForCorporativeCustomer(CorporateCustomer customer, CakeKind cakeKind, int count);

    void processOrderForPrivateCustomer(PrivateCustomer customer, CakeKind cakeKind, int count);

    CakeCatalog getCatalog();
}
