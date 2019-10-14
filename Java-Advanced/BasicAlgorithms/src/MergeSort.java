import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        array = mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middleIndex = array.length / 2;
        int firstArrayLenght = middleIndex;
        int secondArrayLenght = array.length - middleIndex;

        int[] firstPart = new int[firstArrayLenght];
        int[] secondPart = new int[secondArrayLenght];

        for (int i = 0; i < firstArrayLenght; i++) {
            firstPart[i] = array[i];
        }
        for (int i = firstArrayLenght; i < array.length; i++) {
            secondPart[i - middleIndex] = array[i];
        }

        firstPart = mergeSort(firstPart);
        secondPart = mergeSort(secondPart);

        int mainIndex = 0;
        int firstPartIndex = 0;
        int secondPartIndex = 0;

        while (firstPartIndex < firstArrayLenght && secondPartIndex < secondArrayLenght) {
            if (firstPart[firstPartIndex] < secondPart[secondPartIndex]) {
                array[mainIndex] = firstPart[firstPartIndex];

                mainIndex++;
                firstPartIndex++;
            } else {
                array[mainIndex] = secondPart[secondPartIndex];

                mainIndex++;
                secondPartIndex++;
            }
        }

        while (firstPartIndex < firstArrayLenght) {
            array[mainIndex] = firstPart[firstPartIndex];
            mainIndex++;
            firstPartIndex++;
        }

        while (secondPartIndex < secondArrayLenght) {
            array[mainIndex] = secondPart[secondPartIndex];

            mainIndex++;
            secondPartIndex++;
        }
        return array;
    }
}
