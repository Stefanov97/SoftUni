package collectionHierarchy;

import collectionHierarchy.interfaces.Addable;

import java.util.Collections;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String text) {
        this.getItems().add(text);
        return this.getItems().size() - 1;
    }
}
