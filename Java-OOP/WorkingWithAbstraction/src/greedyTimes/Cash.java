package greedyTimes;

public class Cash {
    private String name;
    private long quantity;

    public Cash(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return this.name;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void addQuantity(long value) {
        this.quantity += value;
    }
}
