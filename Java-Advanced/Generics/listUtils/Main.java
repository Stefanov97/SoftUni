import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> asd = new ArrayList<>();

        asd.add(50);
        asd.add(50);
        asd.add(500);
        asd.add(-500);
        System.out.println(ListUtils.getMin(asd));
        System.out.println(ListUtils.getMax(asd));
    }
}
