import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(this.data, firstIndex, secondIndex);
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T currentData : this.data) {
            if (currentData.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        return Collections.max(this.data);
    }

    public T getMin() {
        return Collections.min(this.data);
    }

    public void printElements() {
        this.data.forEach(System.out::println);
    }
}
