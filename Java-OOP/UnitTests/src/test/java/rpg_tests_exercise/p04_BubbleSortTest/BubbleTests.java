package rpg_tests_exercise.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTests {

    @Test
    public void bubbleSortShouldSortCorrectly() {
        int[] myArray = new int[]{-2, 3, 32, 5, -560};
        int[] sortedArray = Arrays.stream(myArray).sorted().toArray();
        int[] clonedArray = myArray.clone();
        Bubble.sort(clonedArray);

        Assert.assertArrayEquals(clonedArray, sortedArray);

    }

}
