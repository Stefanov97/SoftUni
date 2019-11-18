package core.interfaces;

public interface Controller {
    void processOrders();
    String getCakesBeforeOrders();
    String getCakesAfterOrders();
    String getCashRegister();
    String getSuppliersOrderedByTips();
    String getTheBestSellingCake();
    String getTheSupplierWithMaxOrders();
    String getTheCustomerWithHighestBill();
}
