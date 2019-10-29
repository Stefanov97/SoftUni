package collectionHierarchy;

import collectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {


    @Override
    public int getUsed() {
        return this.getItems().size();
    }

    @Override
    public String remove() {
        return this.getItems().remove(0);

    }

    @Override
    public int add(String text) {
        this.getItems().add(0, text);
        return 0;
    }
}
