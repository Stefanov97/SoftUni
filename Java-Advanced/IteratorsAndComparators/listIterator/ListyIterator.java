import java.util.List;

public class ListyIterator {
    private List<String> data;
    int index;

    public ListyIterator(List<String> data) {
        this.data = data;
        this.index = 0;
    }

    public boolean Move() {
        if (index < this.data.size() - 1) {
            index++;
            return true;
        }
        return false;
    }

    public boolean HasNext() {
        return this.index < this.data.size() - 1;
    }

    public void Print() throws IllegalAccessException {
        if (this.data.isEmpty()) {
            throw new IllegalAccessException("Invalid Operation!");
        }
        System.out.println(this.data.get(this.index));
    }
}
