public interface Bank {
    void addAccount(BankAccount bankAccount);

    void removeAccount(int accountNumber);

    void getAccountDetails(int accountNumber);
}
