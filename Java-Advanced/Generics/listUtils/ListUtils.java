import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T firstElement = collection.get(0);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).compareTo(firstElement) < 0) {
                firstElement = collection.get(i);
            }
        }
        return firstElement;
    }

    public static <T extends Comparable<T>> T getMax(List<T> collection) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T firstElement = collection.get(0);
        for (int i = 0; i < collection.size(); i++) {
            if (collection.get(i).compareTo(firstElement) > 0) {
                firstElement = collection.get(i);
            }
        }
        return firstElement;
    }
}
