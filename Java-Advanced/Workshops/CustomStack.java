import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    public CustomStack() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    public int peek() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.data[this.size - 1];
    }

    public void push(int element) {
        this.add(element);
    }

    public int pop() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.remove(this.size - 1);
    }

    private int get(int index) {
        validateIndex(index);
        return this.data[index];
    }

    private int remove(int index) {
        if (this.size - 1 == capacity / 4) {
            this.shrink();
        }
        validateIndex(index);
        this.shiftLeft(index);
        int lastElementToPrint = this.data[this.size - 1];
        this.data[size - 1] = 0;
        this.size--;
        return lastElementToPrint;
    }

    private void add(int element) {
        if (size == capacity) {
            this.resize();
        }
        this.data[size++] = element;

    }

    private void add(int index, int element) {
        validateIndex(index);
        if (this.size == capacity) {
            this.resize();
        }
        this.size++;
        this.shiftRight(index);
        this.data[index] = element;

    }


    private void shrink() {
        this.capacity /= 2;
        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }


    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }


    }


    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }
}
