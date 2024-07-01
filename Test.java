import java.util.*;

public class Test {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BankAccount account = new SavingsAccount(0, 0, null);

        String customerName = "John Doe";
        String accountNumber = account.generateAccountNumber(customerName);

        String lastFourDigits = accountNumber.substring(8);
        String password = "defaultPassword";

        Map<Integer, String> accountDetails = account.getAccountDetails(customerName, lastFourDigits, password);

        while (accountDetails == null) {
            System.out.println("enter correct password to access account details (or type exit to \"quit\"");
            password = sc.nextLine();
            sc.nextLine();

            if (password.equalsIgnoreCase(("exit"))) {
                System.out.println("exiting program...");
                return;
            }
            accountDetails = account.getAccountDetails(customerName, lastFourDigits, password);
        }

        System.out.println("enter a password for this account");
        String newPassword = sc.nextLine();
        account.setPassword(newPassword);

        System.out.println("Forgot Password");
        String storedPassword = account.getPasswordFromFile();
        if (storedPassword != null) {
            System.out.println("Stored password: " + storedPassword);
        } else {
            System.out.println("no stored password found");
        }
    }
}
