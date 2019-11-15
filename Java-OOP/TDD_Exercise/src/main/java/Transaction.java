public interface Transaction {
    int getId();
    String getFrom();
    String getTo();
    double getAmount();
     void setStatus(TransactionStatus status);
    void setFrom(String from);
    void setTo(String to);
    void setAmount(double amount);
    void setId(int id);
    TransactionStatus getTransactionStatus();

}
