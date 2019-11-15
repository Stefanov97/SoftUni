public class TransactionImpl implements Comparable<TransactionImpl>, Transaction{

    private int id;
    private TransactionStatus status;
    private String from;
    private String to;
    private double amount;

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }
    @Override
    public int compareTo(TransactionImpl o) {
        return 0;
    }
    @Override
    public int getId() {
        return this.id;
    }
    @Override
    public String getFrom() {
        return this.from;
    }
    @Override
    public String getTo() {
        return this.to;
    }

    public double getAmount() {
        return this.amount;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public TransactionStatus getTransactionStatus() {
        return this.status;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
    @Override
    public void setFrom(String from) {
        this.from = from;
    }
    @Override
    public void setTo(String to) {
        this.to = to;
    }
@Override
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
