package collectionHierarchy;

import collectionHierarchy.AddCollection;
import collectionHierarchy.AddRemoveCollection;
import collectionHierarchy.MyListImpl;
import collectionHierarchy.interfaces.MyList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyListImpl();

        String[] itemsToAdd = scanner.nextLine().split("\\s+");
        int timesToRemove = Integer.parseInt(scanner.nextLine());

        printAddCollection(addCollection, itemsToAdd);
        printAddRemoveCollection(addRemoveCollection, itemsToAdd);
        printMylist(myList, itemsToAdd);

        removeFromAddRemove(addRemoveCollection, timesToRemove);
        removeFromMyList(myList, timesToRemove);
    }

    private static void removeFromMyList(MyList myList, int timesToRemove) {
        while (timesToRemove-- > 0) {
            System.out.print(myList.remove() + " ");
        }

    }

    private static void removeFromAddRemove(AddRemoveCollection addRemoveCollection, int timesToRemove) {
        while (timesToRemove-- > 0) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
    }

    private static void printMylist(MyList myList, String[] itemsToAdd) {
        for (int i = 0; i < itemsToAdd.length; i++) {
            String text = itemsToAdd[i];
            System.out.print(myList.add(text) + " ");
        }
        System.out.println();
    }

    private static void printAddRemoveCollection(AddRemoveCollection addRemoveCollection, String[] itemsToAdd) {
        for (int i = 0; i < itemsToAdd.length; i++) {
            String text = itemsToAdd[i];
            System.out.print(addRemoveCollection.add(text) + " ");
        }
        System.out.println();
    }

    private static void printAddCollection(AddCollection addCollection, String[] itemsToAdd) {
        for (int i = 0; i < itemsToAdd.length; i++) {
            String text = itemsToAdd[i];
            System.out.print(addCollection.add(text) + " ");
        }
        System.out.println();
    }
}
