import java.util.Iterator;
import java.util.function.Consumer;

public class MyLinkedList implements Iterable<Integer> {


    private class Node {
        Node next;
        Node prev;
        int element;

        public Node(int element) {
            this.next = null;
            this.prev = null;
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    public void add(int element) {
        Node newTail = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newTail;
        } else {
            this.tail.next = newTail;
            newTail.prev = this.tail;
            this.tail = newTail;
        }
        this.size++;
    }

    public int getSize() {
        return this.size;
    }

    public void remove(int elementToRemove) {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from empty list!");
        }
        int whichNodeToRemove = -1;
        Node currentNode = this.head;
        for (int i = 0; i < this.size; i++) {

            if (currentNode.element == elementToRemove) {
                whichNodeToRemove = i;
                this.size--;
                break;
            }
            currentNode = currentNode.next;
        }
        if (whichNodeToRemove > -1) {
            switch (whichNodeToRemove) {
                case 0:
                    if (this.head.next == null) {
                        this.head = this.tail = null;
                    } else {
                        this.head.next.prev = null;
                        this.head = this.head.next;

                    }
                    break;
                case 1:
                    if (this.head.next.next == null) {
                        this.tail = null;
                        this.head.next = null;
                    } else {
                        this.head.next.next.prev = this.head.next.prev;
                        this.head.next = this.head.next.next;

                    }
                    break;
                case 2:
                    if (this.head.next.next.next == null) {
                        this.tail = null;
                        this.head.next.next = null;
                    } else {
                        this.head.next.next.next.prev = this.head.next.next.prev;
                        this.head.next.next = this.head.next.next.next;

                    }
                    break;
                case 3:
                    if (this.head.next.next.next.next == null) {
                        this.tail = null;
                        this.head.next.next.next = null;
                    } else {
                        this.head.next.next.next.next.prev = this.head.next.next.next.prev;
                        this.head.next.next.next = this.head.next.next.next.next;

                    }
                    break;
                case 4:
                    if (this.head.next.next.next.next.next == null) {
                        this.tail = null;
                        this.head.next.next.next.next = null;
                    } else {
                        this.head.next.next.next.next.next.prev = this.head.next.next.next.next.prev;
                        this.head.next.next.next.next = this.head.next.next.next.next.next;

                    }
                    break;
                case 5:
                    if (this.head.next.next.next.next.next.next == null) {
                        this.tail = null;
                        this.head.next.next.next.next.next = null;
                    } else {
                        this.head.next.next.next.next.next.next.prev = this.head.next.next.next.next.next.prev;
                        this.head.next.next.next.next.next = this.head.next.next.next.next.next.next;

                    }
                    break;
                case 6:
                    if (this.head.next.next.next.next.next.next.next == null) {
                        this.tail = null;
                        this.head.next.next.next.next.next.next = null;
                    } else {
                        this.head.next.next.next.next.next.next.next.prev = this.head.next.next.next.next.next.next.prev;
                        this.head.next.next.next.next.next.next = this.head.next.next.next.next.next.next.next;

                    }
                    break;
            }
        }
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node currentNode = head;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int elementToReturn = currentNode.element;
                currentNode = currentNode.next;
                return elementToReturn;
            }
        };
    }
}
