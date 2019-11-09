package rpg_tests_exercise.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTests {
    private CustomLinkedList<Integer> list;

    @Before
    public void initList() {
        this.list = new CustomLinkedList<Integer>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMethodShouldThrowAnExceptionIfNegativeIndexIsGiven() {
        this.list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMethodShouldThrowAnExceptionIfIndexOutOfBoundsIsGiven() {
        this.list.get(0);
    }

    @Test
    public void getMethodShouldReturnCorrectResult() {
        this.list.add(4);
        this.list.add(2);
        this.list.add(7);
        int expected = 7;
        boolean isCorrect = expected == this.list.get(2);
        Assert.assertTrue(isCorrect);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMethodShouldThrowAnExceptionIfNegativeIndexIsGiven() {
        this.list.set(-1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setMethodShouldThrowAnExceptionIfIndexOutOfBoundsIsGiven() {
        this.list.set(0, 4);
    }

    @Test
    public void setMethodShouldReturnCorrectResult() {
        this.list.add(4);
        this.list.add(2);
        this.list.add(7);
        this.list.set(2, 0);
        int expected = 0;
        boolean isCorrect = expected == this.list.get(2);
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void addMethodShouldAddAtTheEndOfTheList() {
        this.list.add(2);
        this.list.add(2);
        this.list.add(2);
        this.list.add(5);
        int expected = 5;
        boolean isCorrect = this.list.get(3) == expected;
        Assert.assertTrue(isCorrect);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowAnExceptionIfNegativeIndexIsGiven() {
        this.list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowAnExceptionIfIndexOutOfBoundsIsGiven() {
        this.list.get(0);
    }

    @Test
    public void removeAtMethodShouldRemoveAtCorrectIndex() {
        this.list.add(4);
        this.list.add(23);
        this.list.add(5);
        this.list.removeAt(1);
        int expected = 5;
        boolean isCorrect = this.list.get(1) == expected;
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void removeAtMethodShouldReturnCorrectValue() {
        this.list.add(4);
        this.list.add(23);
        this.list.add(5);
        int value = this.list.removeAt(1);
        int expected = 23;
        boolean isCorrect = value == expected;
        Assert.assertTrue(isCorrect);

    }

    @Test
    public void removeShouldRemoveTheCorrectItem() {
        this.list.add(2);
        this.list.add(3);
        this.list.remove(3);
        boolean isCorrect = this.list.contains(3);
        Assert.assertFalse(isCorrect);
    }

    @Test
    public void removeShouldReturnNegativeIndexIfTheItemIsNotPresent() {
        this.list.add(2);
        this.list.add(3);
        int index = this.list.remove(5);
        int expectedIndex = -1;
        boolean isCorrect = expectedIndex == index;
        Assert.assertTrue(isCorrect);

    }

    @Test
    public void removeShouldReturnCorrectIndex() {
        this.list.add(2);
        this.list.add(3);
        int index = this.list.remove(2);
        int expectedIndex = 0;
        boolean isCorrect = expectedIndex == index;
        Assert.assertTrue(isCorrect);

    }

    @Test
    public void indexOfMethodShouldReturnNegativeIndexIfItemNotPresent() {
        this.list.add(2);
        this.list.add(3);
        int index = this.list.indexOf(22);
        int expectedIndex = -1;
        boolean isCorrect = expectedIndex == index;
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void indexOfMethodShouldReturnFirstOccurrenceOfTheElementIndex() {
        this.list.add(2);
        this.list.add(2);
        int index = this.list.indexOf(2);
        int expectedIndex = 0;
        boolean isCorrect = expectedIndex == index;
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void containsMethodShouldReturnTrueIfElementIsPresent() {
        this.list.add(3);
        boolean isCorrect = this.list.contains(3);
        Assert.assertTrue(isCorrect);
    }

    @Test
    public void containsMethodShouldReturnFalseIfElementIsNotPresent() {
        this.list.add(3);
        boolean isCorrect = this.list.contains(32);
        Assert.assertFalse(isCorrect);
    }

}