
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> bankAccountMap = new LinkedHashMap<>();
        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    int keyId = bankAccount.getId();
                    bankAccountMap.put(keyId, bankAccount);
                    System.out.printf("Account ID%d created%n", keyId);
                    break;
                case "Deposit": {
                    int id = Integer.parseInt(tokens[1]);
                    int amount = Integer.parseInt(tokens[2]);
                    if (!bankAccountMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount currentAccount = bankAccountMap.get(id);
                        currentAccount.deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, currentAccount.getId());
                    }

                    break;
                }
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccount.interestRate = interest;

                    break;
                case "GetInterest":
                    int id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    if (!bankAccountMap.containsKey(id)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount currentAccount = bankAccountMap.get(id);
                        System.out.printf("%.2f%n", currentAccount.getInterest(years));
                    }

                    break;
            }
            line = scanner.nextLine();
        }
    }
}
