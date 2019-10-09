import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("\\|+");
        String arrayResult = "";
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) {
                arrayResult = array[i].trim() + " ";
            } else {
                arrayResult += array[i] + " ";
            }
        }
        String[] realResult = arrayResult.split(" +");

        for (String s : realResult) {
            System.out.print(s + " ");
        }


    }
}
