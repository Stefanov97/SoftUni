import java.util.*;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> listOfProducts = new ArrayList();
        for (int i = 0; i < n; i++) {
            listOfProducts.add(scanner.nextLine());
        }
        Collections.sort(listOfProducts);

        for (int i = 0; i < n; i++) {
            System.out.printf("%d.%s", i + 1, listOfProducts.get(i)).println();
        }
    }
}
