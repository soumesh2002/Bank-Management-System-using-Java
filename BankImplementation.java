import java.util.HashMap;
import java.util.Map;

public class BankImplementation implements Bank {
    private Map<Integer, BankAccount> accounts;

    public BankImplementation() {
        this.accounts = new HashMap<>();
    }

    @Override
    public void addAccount(BankAccount bankAccount) {
        accounts.put(bankAccount.getAccountNumber(), bankAccount);
    }

    @Override
    public void removeAccount(int accountNumber) {
        accounts.remove(accountNumber);
    }

    @Override
    public void getAccountDetails(int accountNumber) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Owner Name: " + account.getOwnerName());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found. Please create a bank account.");
        }
    }
}