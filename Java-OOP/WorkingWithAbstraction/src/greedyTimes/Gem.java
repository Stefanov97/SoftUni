package greedyTimes;

public class Gem {
    private String name;
    private long quantity;

    public Gem(String name, long quantity) {
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
