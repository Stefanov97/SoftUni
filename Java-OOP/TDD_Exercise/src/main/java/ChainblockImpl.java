import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> trasactions;

    public ChainblockImpl() {
        this.trasactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return this.trasactions.size();
    }

    public void add(Transaction transaction) {

        this.trasactions.put(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.trasactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.trasactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Transaction transaction = this.trasactions.get(id);
        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.trasactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        this.trasactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.trasactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        return this.trasactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        this.trasactions.values().stream().filter(transaction -> transaction.getTransactionStatus().equals(status)).collect(Collectors.toList());
        List<Transaction> filtered = this.trasactions.values().stream().filter(transaction -> transaction.getTransactionStatus().equals(status)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return filtered;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = this.trasactions.values().stream().filter(transaction -> transaction.getTransactionStatus().equals(status)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).collect(Collectors.toList());

        if (filteredTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> filtered = new ArrayList<>();
        for (Transaction transaction : filteredTransactions) {
            filtered.add(transaction.getFrom());
        }

        return filtered;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = this.trasactions.values().stream().filter(transaction -> transaction.getTransactionStatus().equals(status)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).collect(Collectors.toList());

        if (filteredTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> filtered = new ArrayList<>();
        for (Transaction transaction : filteredTransactions) {
            filtered.add(transaction.getTo());
        }

        return filtered;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.trasactions.values().stream().sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> list = this.trasactions.values().stream().filter(transaction -> transaction.getFrom().equals(sender)).sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount())).collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> list = this.trasactions.values().stream().filter(transaction -> transaction.getTo().equals(receiver)).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.trasactions.values().stream().filter(transaction1 -> transaction1.getTransactionStatus().equals(status) && transaction1.getAmount() <= amount).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            return result;
        }).collect(Collectors.toList());

    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> list = this.trasactions.values().stream().filter(transaction1 -> transaction1.getFrom().equals(sender) && transaction1.getAmount() > amount).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            return result;
        }).collect(Collectors.toList());
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> filtered = this.trasactions.values().stream().filter(transaction1 -> transaction1.getTo().equals(receiver) && transaction1.getAmount() >= lo && transaction1.getAmount() < hi).sorted((f, s) -> {
            int result = Double.compare(s.getAmount(), f.getAmount());
            if (result == 0) {
                result = f.getId() - s.getId();
            }
            return result;
        }).collect(Collectors.toList());
        if (filtered.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return filtered;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.trasactions.values().stream().filter(transaction1 -> transaction1.getAmount() >= lo && transaction1.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return this.trasactions.values().iterator();
    }

}
