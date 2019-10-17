import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Jar<T> {
    private ArrayDeque<T> jars;

    public Jar() {
        this.jars = new ArrayDeque<>();
    }

    public void add(T element) {
        this.jars.push(element);

    }
    public T remove() {
        return this.jars.pop();
    }
}
