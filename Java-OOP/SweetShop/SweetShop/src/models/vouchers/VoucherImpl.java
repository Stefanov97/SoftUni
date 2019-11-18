package models.vouchers;

import models.vouchers.interfaces.Voucher;

public class VoucherImpl implements Voucher{
    private double value;
    public VoucherImpl(double value){
        this.value = value;
    }
    @Override
    public double getValue() {
        return this.value;
    }
}
