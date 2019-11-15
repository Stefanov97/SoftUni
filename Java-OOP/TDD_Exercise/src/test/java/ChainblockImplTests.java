import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

public class ChainblockImplTests {
    private Chainblock chainblock;
    private TransactionImpl transaction;

    @Before
    public void initialize() {
        this.chainblock = new ChainblockImpl();
        this.transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "A", "B", 100);
    }

    @Test
    public void containsIdMethodShouldReturnTrueIfTheTransactionIsPresent() {
        this.chainblock.add(this.transaction);
        Assert.assertTrue(this.chainblock.contains(this.transaction.getId()));
    }

    @Test
    public void containsIdMethodShouldReturnFalseIfTheTransactionIsNotPresent() {
        Assert.assertFalse(this.chainblock.contains(this.transaction.getId()));
    }

    @Test
    public void addMethodShouldIncreaseSizeProperly() {
        this.chainblock.add(transaction);
        Assert.assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void addMethodShouldAddCorrectTransaction() {
        this.chainblock.add(transaction);
        Assert.assertTrue(this.chainblock.contains(transaction.getId()));
    }

    @Test
    public void getCountMethodShouldReturnZeroIfEmptyCollectionISGiven() {
        Assert.assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void getCountMethodShouldReturnFiveIfFiveElementsAreAdded() {
        List<Transaction> transactions = createTransactions(5);
        for (Transaction tran : transactions) {
            this.chainblock.add(tran);
        }
        Assert.assertEquals(5, this.chainblock.getCount());
    }

    @Test
    public void getCountMethodShouldReturnThreefThreeElementsAreAdded() {
        List<Transaction> transactions = createTransactions(3);
        for (Transaction tran : transactions) {
            this.chainblock.add(tran);
        }
        Assert.assertEquals(3, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowAnExceptionIfTheGivenTransactionIsNotPresent() {
        this.chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void changeTransactionStatusShouldChangeTheTransactionStatusWithTheGivenOne() {
        this.chainblock.add(transaction);
        this.chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
        TransactionStatus expected = TransactionStatus.ABORTED;
        TransactionStatus actual = transaction.getTransactionStatus();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIDShouldThrowAnExceptionIfTheGivenTransactionDoesNotExist() {
        this.chainblock.removeTransactionById(1);
    }

    @Test
    public void removeTransactionByIDShouldDecreaseSizeWhenTransactionIsRemoved() {
        this.chainblock.add(transaction);
        this.chainblock.removeTransactionById(1);
        Assert.assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void removeTransactionByIDShouldNotContainsTheRemovedTransaction() {
        this.chainblock.add(transaction);
        this.chainblock.removeTransactionById(1);
        Assert.assertFalse(this.chainblock.contains(transaction.getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTransactionByIDShouldThrowAnExceptionIfTheGivenTransactionDoesNotExist() {
        this.chainblock.getById(1);
    }

    @Test
    public void getTransactionByIDShouldReturnTheGivenTransaction() {
        this.chainblock.add(transaction);
        this.chainblock.getById(1);
        Assert.assertEquals(transaction.getId(), this.chainblock.getById(1).getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowAnExceptionIfThereAreNoTransactionWithTheGivenStatus() {
        this.chainblock.add(transaction);
        this.chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getByTransactionStatusShouldReturnTransactionsWIthTheGivenStatusOrderedDescending() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setAmount(50);
        transactionList.get(1).setAmount(60);
        transactionList.get(2).setAmount(30);

        Iterable<Transaction> byTransactionStatus = this.chainblock.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        Transaction[] transactions = StreamSupport.stream(byTransactionStatus.spliterator(), false).toArray(Transaction[]::new);
        Transaction[] expected = transactionList.stream().sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, transactions);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowAnExceptionIfThereAreNoTransactionsWithTheGivenStatus() {
        this.chainblock.add(transaction);
        this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllSendersWithTransactionStatusShouldReturnAllSendersWithThisTransactionStatusOrderedByTotalAmount() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setAmount(50);
        transactionList.get(1).setAmount(60);
        transactionList.get(2).setAmount(30);
        transactionList.get(0).setFrom("A");
        transactionList.get(1).setFrom("F");
        transactionList.get(2).setFrom("C");
        transactionList.get(2).setStatus(TransactionStatus.ABORTED);


        Transaction[] expectedTransactions = transactionList.stream().filter(currentTransaction -> currentTransaction.getTransactionStatus().equals(TransactionStatus.SUCCESSFUL)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).toArray(Transaction[]::new);
        String[] expectedNames = new String[expectedTransactions.length];
        for (int i = 0; i < expectedNames.length; i++) {
            expectedNames[i] = expectedTransactions[i].getFrom();
        }

        Iterable<String> allSendersWithTransactionStatus = this.chainblock.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        String[] actualNames = StreamSupport.stream(allSendersWithTransactionStatus.spliterator(), false).toArray(String[]::new);
        Assert.assertArrayEquals(expectedNames, actualNames);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowAnExceptionIfThereAreNoTransactionsWithTheGivenStatus() {
        this.chainblock.add(transaction);
        this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnAllReceiversWithThisTransactionStatusOrderedByTotalAmount() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setAmount(50);
        transactionList.get(1).setAmount(60);
        transactionList.get(2).setAmount(30);
        transactionList.get(0).setTo("A");
        transactionList.get(1).setTo("F");
        transactionList.get(2).setTo("C");
        transactionList.get(2).setStatus(TransactionStatus.ABORTED);


        Transaction[] expectedTransactions = transactionList.stream().filter(currentTransaction -> currentTransaction.getTransactionStatus().equals(TransactionStatus.SUCCESSFUL)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).toArray(Transaction[]::new);
        String[] expectedNames = new String[expectedTransactions.length];
        for (int i = 0; i < expectedNames.length; i++) {
            expectedNames[i] = expectedTransactions[i].getTo();
        }

        Iterable<String> allReceiversWithTransactionStatus = this.chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        String[] actualNames = StreamSupport.stream(allReceiversWithTransactionStatus.spliterator(), false).toArray(String[]::new);
        Assert.assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    public void getAllOrderedByAmountThenByIdShouldReturnTheTransactionsOrderedProperly() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setAmount(20);
        transactionList.get(1).setAmount(50);
        transactionList.get(2).setAmount(20);
        transactionList.get(0).setId(3);
        transactionList.get(1).setId(50);
        transactionList.get(2).setId(2);
        Transaction[] expected = transactionList.stream().sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).toArray(Transaction[]::new);

        Iterable<Transaction> getAllOrdered = this.chainblock.getAllOrderedByAmountDescendingThenById();
        Transaction[] actual = StreamSupport.stream(getAllOrdered.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByDescendingShouldThrowAnExceptionIfThereAreNoTransactionsWithThisSender() {
        this.chainblock.getBySenderOrderedByAmountDescending("A");

    }

    @Test
    public void getBySenderOrderedByDescendingShouldReturnAllTransactionsWithThisSenderOrderedByAmountDescending() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setFrom("A");
        transactionList.get(1).setFrom("B");
        transactionList.get(2).setFrom("A");
        transactionList.get(0).setAmount(3);
        transactionList.get(1).setAmount(50);
        transactionList.get(2).setAmount(5);
        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getFrom().equals("A")).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).toArray(Transaction[]::new);
        Iterable<Transaction> getBySender = this.chainblock.getBySenderOrderedByAmountDescending("A");
        Transaction[] actual = StreamSupport.stream(getBySender.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByIdShouldThrowAnExceptionIfThereAreNoTransactionsWithThisReceiver() {
        this.chainblock.getByReceiverOrderedByAmountThenById("A");

    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnAllReceiversOrderedDescendingByAmountThenAscendingByID() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setTo("A");
        transactionList.get(1).setTo("B");
        transactionList.get(2).setTo("A");
        transactionList.get(0).setAmount(3);
        transactionList.get(1).setAmount(50);
        transactionList.get(2).setAmount(5);
        transactionList.get(0).setId(3);
        transactionList.get(1).setId(50);
        transactionList.get(2).setId(1);
        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getTo().equals("A")).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).toArray(Transaction[]::new);
        Iterable<Transaction> getBySender = this.chainblock.getByReceiverOrderedByAmountThenById("A");
        Transaction[] actual = StreamSupport.stream(getBySender.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyCollectionIfNoSuchTransactionsWereFound() {
        Transaction[] expected = new Transaction[0];
        Iterable<Transaction> getByTransactionStatus = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 4);
        Transaction[] actual = StreamSupport.stream(getByTransactionStatus.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnAllTransactionsWithGivenStatusAndAmountLessOrEqualToTheMaximumAllowedOrderedByAmountInDescending() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setStatus(TransactionStatus.ABORTED);
        transactionList.get(1).setStatus(TransactionStatus.ABORTED);
        transactionList.get(2).setStatus(TransactionStatus.SUCCESSFUL);
        transactionList.get(0).setAmount(3);
        transactionList.get(1).setAmount(50);
        transactionList.get(2).setAmount(5);

        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getTransactionStatus().equals(TransactionStatus.ABORTED) && transaction1.getAmount() <= 50).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            return result;
        }).toArray(Transaction[]::new);
        Iterable<Transaction> getBySender = this.chainblock.getByTransactionStatusAndMaximumAmount(TransactionStatus.ABORTED, 50);
        Transaction[] actual = StreamSupport.stream(getBySender.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowAnExceptionIfThereAreNoSuchTransactions() {
        this.chainblock.getBySenderAndMinimumAmountDescending("A", 5);
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnAllTransactionsWithTheGivenSenderAndAmountBiggerThanTheGivenOrderedByAmountInDescendingOrder() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setFrom("A");
        transactionList.get(1).setFrom("B");
        transactionList.get(2).setFrom("A");
        transactionList.get(0).setAmount(51);
        transactionList.get(1).setAmount(4);
        transactionList.get(2).setAmount(70);

        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getFrom().equals("A") && transaction1.getAmount() > 50).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            return result;
        }).toArray(Transaction[]::new);
        Iterable<Transaction> getBySender = this.chainblock.getBySenderAndMinimumAmountDescending("A", 50);
        Transaction[] actual = StreamSupport.stream(getBySender.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowAnExceptionIfThereAreNoSuchTransactions() {
        this.chainblock.getByReceiverAndAmountRange("A", 5, 6);
    }

    @Test
    public void getByReceiverAndAmountRangeShouldReturnAllTransactionsWithTheGivenReceiverAndAmountBetweenTheRangeGiven() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setTo("A");
        transactionList.get(1).setTo("B");
        transactionList.get(2).setTo("A");
        transactionList.get(0).setAmount(50);
        transactionList.get(1).setAmount(4);
        transactionList.get(2).setAmount(70);

        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getTo().equals("A") && transaction1.getAmount() >= 50 && transaction1.getAmount() < 71).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).toArray(Transaction[]::new);
        Iterable<Transaction> getByReceiverAndAmountRange = this.chainblock.getByReceiverAndAmountRange("A", 50, 71);
        Transaction[] actual = StreamSupport.stream(getByReceiverAndAmountRange.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyCollectionIfNoSuchTransactionsWereFound() {
        Transaction[] expected = new Transaction[0];
        Iterable<Transaction> getByTransactionStatus = this.chainblock.getAllInAmountRange(1, 4);
        Transaction[] actual = StreamSupport.stream(getByTransactionStatus.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllInAmountRangeShouldReturnAllTransactionsInTheGivenRangeInclusiveByTheInsertionOrder() {
        List<Transaction> transactionList = new ArrayList<>();
        for (Transaction currentTransaction : this.createTransactions(3)) {
            transactionList.add(currentTransaction);
            this.chainblock.add(currentTransaction);
        }
        transactionList.get(0).setAmount(1);
        transactionList.get(1).setAmount(4);
        transactionList.get(2).setAmount(70);

        Transaction[] expected = transactionList.stream().filter(transaction1 -> transaction1.getAmount() >= 1 && transaction1.getAmount() <= 4)
                .toArray(Transaction[]::new);
        Iterable<Transaction> getByReceiverAndAmountRange = this.chainblock.getAllInAmountRange(1, 4);
        Transaction[] actual = StreamSupport.stream(getByReceiverAndAmountRange.spliterator(), false).toArray(Transaction[]::new);
        Assert.assertArrayEquals(expected, actual);
    }

    private List<Transaction> createTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();
        while (count > 0) {
            Transaction transaction = new TransactionImpl(count * 5, TransactionStatus.SUCCESSFUL, UUID.randomUUID().toString(), UUID.randomUUID().toString(), 23 * count);
            transactions.add(transaction);
            count--;
        }

        return transactions;
    }
}