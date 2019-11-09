package rpg_tests_exercise.p02_DatabaseExtended;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_tests_exercise.p02_ExtendedDatabase.Database;
import rpg_tests_exercise.p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class PersonDatabaseTests {
    private Database db;

    @Before
    public void initDatabase() throws OperationNotSupportedException {
        this.db = new Database(new Person(5, "A"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithMoreThanSixteenElementsShouldThrowAnException() throws OperationNotSupportedException {
        Person[] array = new Person[17];
        this.db = new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void initializeDatabaseWithLessThanOneElementShouldThrowAnException() throws OperationNotSupportedException {
        Person[] array = new Person[0];
        this.db = new Database(array);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionIfNullElementIsPassed() throws OperationNotSupportedException {
        this.db.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionIfNegativeElementIsPassed() throws OperationNotSupportedException {
        this.db.add(new Person(-4, "B"));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionIfThereIsAlreadyUserWithThisID() throws OperationNotSupportedException {
        this.db.add(new Person(5, "C"));
    }

    @Test
    public void arrayShouldIncreaseSizeAfterAddingAnElement() throws OperationNotSupportedException {
        int sizeBefore = this.db.getElements().length;
        this.db.add(new Person(6, "H"));
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
        this.db.add(new Person(4, "A"));
        this.db.remove();
        boolean isTheLastRemoved = true;
        for (Person element : this.db.getElements()) {
            if (element.getId() == 4) {
                isTheLastRemoved = false;
            }
        }
        Assert.assertTrue(isTheLastRemoved);

    }

    @Test
    public void getElementsMethodShouldReturnCorrectArray() throws OperationNotSupportedException {
        Person[] personsAdded = new Person[]{new Person(2, "A"), new Person(3, "A"), new Person(4, "A")};
        this.db = new Database(personsAdded);
        Person[] elements = this.db.getElements();

        Assert.assertArrayEquals(personsAdded, elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMethodShouldThrowExceptionIFNoUserIsPresentByThisUsername() throws OperationNotSupportedException {
        this.db.findByUsername("Pesho");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMethodShouldThrowExceptionIFNullIsPassed() throws OperationNotSupportedException {
        this.db.findByUsername(null);
    }

    @Test
    public void namesShouldBeCaseSensitive() throws OperationNotSupportedException {
        this.db.add(new Person(70, "a"));
        Person found = this.db.findByUsername("a");
        Assert.assertEquals(70, found.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIDMethodShouldThrowExceptionIFNoUserIsPresentByThisID() throws OperationNotSupportedException {
        this.db.findById(1551561);
    }

}
