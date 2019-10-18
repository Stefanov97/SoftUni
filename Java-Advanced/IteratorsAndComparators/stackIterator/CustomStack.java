import java.util.Iterator;

public class CustomStack implements Iterable<Integer> {

    private class Node {
        private int element;
        private Node prev;

        public Node(int element) {
            this.element = element;
            this.prev = null;
        }
    }

    private Node top;

    public CustomStack() {
        this.top = null;
    }

    public void push(int element) {
        Node node = new Node(element);
        if (this.top == null) {
            this.top = node;

        } else {
            node.prev = this.top;
            this.top = node;
        }
    }

    public int pop() {
        if (this.top == null) {
            throw new NullPointerException("No elements");
        }
        int element = this.top.element;
        this.top = this.top.prev;
        return element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node firstNode = top;

            @Override
            public boolean hasNext() {
                return firstNode != null;
            }

            @Override
            public Integer next() {
                int element = firstNode.element;
                firstNode = firstNode.prev;
                return element;
            }
        };
    }
}
