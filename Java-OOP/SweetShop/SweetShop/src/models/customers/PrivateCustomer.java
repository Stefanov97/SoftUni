package models.customers;

import models.cakes.enums.CakeKind;
import models.sweetShops.interfaces.SweetShop;
import models.vouchers.interfaces.Voucher;

import java.util.Arrays;
import java.util.List;

public class PrivateCustomer extends BaseCustomer {
    private List<Voucher> vouchers;
    public PrivateCustomer(String name, String phoneNumber,Voucher... vouchers) {
        super(name, phoneNumber);
        this.vouchers = Arrays.asList(vouchers);
    }

    public List<Voucher> getVouchers() {
        return this.vouchers;
    }

    public void order(SweetShop sweetShop, CakeKind cakeKind, int count) {
    sweetShop.processOrderForPrivateCustomer(this,cakeKind,count);
    }
}
