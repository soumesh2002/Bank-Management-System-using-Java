public class CheckingAccount extends BankAccount {

    public CheckingAccount(int accountNumber, double balance, String ownerName) {
        super(accountNumber, balance, ownerName);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
        } else {
            System.err.println("Insufficient funds. Could not complete the transaction.");
        }
    }
}
