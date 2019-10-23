import java.util.function.Consumer;

public class DoublyLinkedList {
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

    public void addFirst(int element) {
        Node newHead = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newHead;
        } else {
            this.head.prev = newHead;
            newHead.next = this.head;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(int element) {
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

    public int get(int index) {

        Node currentNode = this.head;
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        int countNodes = 0;
        int element = 0;
        while (currentNode != null) {
            if (index == countNodes++) {
                element = currentNode.element;
            }

            currentNode = currentNode.next;
        }
        return element;
    }

    public int removeFirst() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from empty list!");
        }
        int element = this.head.element;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;

        }

        this.size--;
        return element;
    }

    public int removeLast() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from empty list!");
        }
        int element = this.tail.element;
        this.tail = this.tail.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }


        this.size--;

        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.element);

            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int index = 0;
        Node currentNode = this.head;
        while (currentNode != null) {
            array[index++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return array;
    }
}
