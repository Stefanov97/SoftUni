import java.util.Collections;

public class Sorter<T extends Comparable> {

    public static <T extends Comparable<T>> void sort(CustomList<T> collection) {
        for (int i = 0; i < collection.size(); i++) {
            for (int j = i + 1; j < collection.size(); j++) {
                T firstElement = collection.getElement(i);
                T secondElement = collection.getElement(j);
                if (firstElement.compareTo(secondElement) > 0) {
                    T temp = firstElement;
                    collection.setElement(i, collection.getElement(j));
                    collection.setElement(j, temp);
                }
            }
        }
    }
}
