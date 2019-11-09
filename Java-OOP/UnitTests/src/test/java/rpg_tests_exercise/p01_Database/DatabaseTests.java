package rpg_tests_exercise.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private static final int VALUE_BIGGER_THAN_SIXTEEN = 17;
    private static final int VALUE_LESS_THAN_ONE = 0;
    private Database db;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.db = new Database(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithMoreThanSixteenElementsShouldThrowAnException() throws OperationNotSupportedException {
        Integer[] array = new Integer[VALUE_BIGGER_THAN_SIXTEEN];
        this.db = new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithLessThanOneElementShouldThrowAnException() throws OperationNotSupportedException {
        Integer[] array = new Integer[VALUE_LESS_THAN_ONE];
        this.db = new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowAnExceptionIfNullElementIsPassed() throws OperationNotSupportedException {
        db.add(null);
    }

    @Test
    public void addMethodShouldAddElementsAtTheNextFreeCell() throws OperationNotSupportedException {
        this.db.add(5);
        this.db.add(6);
        int expected = 6;
        Integer element = this.db.getElements()[this.db.getElements().length - 1];
        boolean areEqual = expected == element;
        Assert.assertTrue(areEqual);
    }

    @Test
    public void arrayShouldIncreaseSizeAfterAddingAnElement() throws OperationNotSupportedException {
        int sizeBefore = this.db.getElements().length;
        this.db.add(4);
        int sizeAfter = this.db.getElements().length;
        int expected = 2;
        boolean isTrue = expected == sizeAfter;
        Assert.assertTrue(isTrue);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removingFromEmptyCollectionShouldThrowAnException() throws OperationNotSupportedException {
        this.db.remove();
        this.db.remove();
    }

    @Test
    public void removeOperationShouldRemoveTheLastElement() throws OperationNotSupportedException {
        this.db.add(4);
        this.db.remove();
        boolean isTheLastRemoved = true;
        for (Integer element : this.db.getElements()) {
            if (element == 4) {
                isTheLastRemoved = false;
            }
        }
        Assert.assertTrue(isTheLastRemoved);

    }
}
