public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02d;
    private static int accountNumber = 1;
    private int id = accountNumber++;
    private double balance;
    public static double interestRate = DEFAULT_INTEREST_RATE;


    public int getId() {
        return id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
