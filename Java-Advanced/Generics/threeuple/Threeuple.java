public class Threeuple<T1, T2, T3> {
    private T1 item;
    private T2 item2;
    private T3 item3;


    public T1 getItem() {
        return item;
    }

    public void setItem(T1 item) {
        this.item = item;
    }

    public T2 getItem2() {
        return item2;
    }

    public void setItem2(T2 item2) {
        this.item2 = item2;
    }

    public T3 getItem3() {
        return item3;
    }

    public void setItem3(T3 item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(item + " -> " + item2 + " -> " + item3);

        return sb.toString().trim();
    }
}
