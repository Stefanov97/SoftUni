package rpg_tests_exercise.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private ListIterator listIterator;
    @Before
    public void initListIterator() throws OperationNotSupportedException {
        this.listIterator = new ListIterator("A", "B");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void creatingAnInstanceWithNullArgumentShouldThrowAnException() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(null);
    }

    @Test
    public void moveShouldIncrementCurrentIndex() throws OperationNotSupportedException {
        this.listIterator.move();
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertFalse(hasNext);
    }

    @Test
    public void moveMethodShouldReturnTrueIfSuccessfullyMoved() throws OperationNotSupportedException {
        boolean hasMoved = this.listIterator.move();
        Assert.assertTrue(hasMoved);

    }

    @Test
    public void moveMethodShouldReturnFalseIfNotSuccessfullyMoved() throws OperationNotSupportedException {
        this.listIterator.move();
        boolean hasMoved = this.listIterator.move();
        Assert.assertFalse(hasMoved);

    }

    @Test
    public void hasNextMethodShouldReturnTrueIfThereIsNextIndex() throws OperationNotSupportedException {
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertTrue(hasNext);
    }

    @Test
    public void hasNextMethodShouldReturnFalseIfThereIsNoNextIndex() throws OperationNotSupportedException {
        this.listIterator.move();
        boolean hasNext = this.listIterator.hasNext();
        Assert.assertFalse(hasNext);
    }

    @Test(expected = IllegalStateException.class)
    public void printMethodShouldThrowAnExceptionIfThereAreNoElements() throws OperationNotSupportedException {
        this.listIterator = new ListIterator();
        this.listIterator.print();
    }

    @Test
    public void printMethodShouldPrintTheCurrentElement() throws OperationNotSupportedException {
        this.listIterator.move();
        String print = this.listIterator.print();
        Assert.assertEquals("B", print);
    }
}
