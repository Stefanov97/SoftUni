package collectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int MAX_SIZE = 100;
    private List<String> items;

    public Collection() {
        this.items = new ArrayList<>();
    }

    public List<String> getItems() {
        return this.items;
    }
}
