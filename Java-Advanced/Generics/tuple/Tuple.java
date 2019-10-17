public class Tuple<T1, T2> {
    private T1 item;
    private T2 item2;

    public Tuple(T1 item, T2 item2) {
        this.item = item;
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return this.item + " -> " + this.item2;
    }
}
