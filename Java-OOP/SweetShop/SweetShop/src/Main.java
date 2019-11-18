import core.ControllerImpl;
import core.EngineImpl;
import core.interfaces.Controller;
import core.interfaces.Engine;
import models.enums.CakeKind;
import models.enums.CakeType;
import models.cakes.childCakes.BaptismCake;
import models.cakes.childCakes.BirthdayCake;
import models.cakes.childCakes.ChildCake;
import models.cakes.childCakes.PurveyorCake;
import models.cakes.interfaces.Cake;
import models.cakes.specialCakes.AdvertisingCake;
import models.cakes.specialCakes.AnniversaryCake;
import models.cakes.specialCakes.FirmCake;
import models.cakes.specialCakes.SpecialCake;
import models.cakes.standardCakes.*;
import models.cakes.weddingCakes.LargeCake;
import models.cakes.weddingCakes.MediumCake;
import models.cakes.weddingCakes.SmallCake;
import models.cakes.weddingCakes.WeddingCake;
import models.customers.CorporateCustomer;
import models.customers.PrivateCustomer;
import models.customers.interfaces.Customer;
import models.suppliers.SupplierImpl;
import models.suppliers.interfaces.Supplier;
import models.sweetShops.SweetShopImpl;
import models.sweetShops.interfaces.SweetShop;
import models.vouchers.VoucherImpl;
import models.vouchers.interfaces.Voucher;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String[] names = new String[]{"Supplier1","Supplier2","Supplier3","Supplier4","Supplier5"};
        String[] privateCustomerNames = new String[]{"PrivateCustomer1","PrivateCustomer2","PrivateCustomer3","PrivateCustomer4","PrivateCustomer5"};
        String[] corporativeCustomerNames = new String[]{"CorporateCustomer1","CorporateCustomer2","CorporateCustomer3","CorporateCustomer4","CorporateCustomer5"};
        List<Supplier> suppliers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Supplier supplier = new SupplierImpl(names[i], UUID.randomUUID().toString());
            suppliers.add(supplier);
        }
        SweetShop sweetShop = new SweetShopImpl("Sweet Talents", "Studentski grad", "0888888888888888", suppliers);
        List<Customer> customers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            CorporateCustomer corporateCustomer = new CorporateCustomer(corporativeCustomerNames[i-1], UUID.randomUUID().toString(), i * 10.0);
            customers.add(corporateCustomer);
        }
        for (int i = 1; i <= 5; i++) {
            Voucher voucher = new VoucherImpl(i * 2);
            PrivateCustomer privateCustomer = new PrivateCustomer(privateCustomerNames[i-1], UUID.randomUUID().toString(), voucher);
            customers.add(privateCustomer);
        }
        for (int i = 0; i < 30; i++) {
            CakeKind[] cakeKindValues = CakeKind.values();
            CakeKind cakeKind = cakeKindValues[i % cakeKindValues.length];
            Cake cake = createCake(cakeKind);
            CakeType cakeType = cake.getCakeType();
            switch (cakeType) {
                case CHILD: {
                    ChildCake currentCake = (ChildCake) cake;
                    sweetShop.getCatalog().addChildCake(currentCake);
                    break;
                }
                case SPECIAL: {
                    SpecialCake currentCake = (SpecialCake) cake;
                    sweetShop.getCatalog().addSpecialCake(currentCake);
                    break;
                }
                case WEDDING: {
                    WeddingCake currentCake = (WeddingCake) cake;
                    sweetShop.getCatalog().addWeddingCake(currentCake);
                    break;
                }
                case STANDARD:
                    StandardCake currentCake = (StandardCake) cake;
                    sweetShop.getCatalog().addStandardCake(currentCake);
                    break;
            }
        }
        Controller controller = new ControllerImpl(sweetShop, customers);
        Engine engine = new EngineImpl(controller);
        engine.run();
    }

    private static Cake createCake(CakeKind cakeKind) {
        Cake cake = null;
        switch (cakeKind) {
            case CHOCOLATE:
                cake = new ChocolateCake();
                break;
            case COOKIE:
                cake = new CookieCake();
                break;
            case ECLAIR:
                cake = new EclairCake();
                break;
            case FRUIT:
                cake = new FruitCake();
                break;
            case SMALL:
                cake = new SmallCake();
                break;
            case MEDIUM:
                cake = new MediumCake();
                break;
            case LARGE:
                cake = new LargeCake();
                break;
            case ANNIVERSARY:
                cake = new AnniversaryCake("A");
                break;
            case ADVERTISING:
                cake = new AdvertisingCake("A");
                break;
            case FIRM:
                cake = new FirmCake("A");
                break;
            case BAPTISM:
                cake = new BaptismCake("B");
                break;
            case BIRTHDAY:
                cake = new BirthdayCake("B");
                break;
            case PURVEYOR:
                cake = new PurveyorCake("B");
                break;
        }
        return cake;
    }
}
