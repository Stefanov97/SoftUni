package collectionHierarchy;

import collectionHierarchy.Collection;
import collectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return this.getItems().remove(this.getItems().size() - 1);
    }

    @Override
    public int add(String text) {
        this.getItems().add(0, text);
        return 0;
    }
}
