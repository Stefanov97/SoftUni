package core;
import core.interfaces.Controller;
import core.interfaces.Engine;

public class EngineImpl implements Engine {
    private Controller controller;
    public EngineImpl(Controller controller){
        this.controller = controller;
    }

    @Override
    public void run() {
        System.out.println(this.controller.getCakesBeforeOrders());
        this.controller.processOrders();
        System.out.println(this.controller.getCakesAfterOrders());
        System.out.println(this.controller.getCashRegister());
        System.out.println(this.controller.getSuppliersOrderedByTips());
        System.out.println(this.controller.getTheBestSellingCake());
        System.out.println(this.controller.getTheSupplierWithMaxOrders());
        System.out.println(this.controller.getTheCustomerWithHighestBill());

    }
}
