import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class BankAccount {
    private int accountNumber;
    private double balance;
    private String ownerName;
    private static final String DIRECTORY_PATH = "C:\\Users\\soume\\OneDrive\\Java Programming\\Bank Management System\\customerDetails\\";
    private static final String PASSWORD_FILE_SUFFIX = "_password.txt";
    private String accountPassword;
    private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public BankAccount(int accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
        this.accountPassword = generateDefaultPassword();
        writePasswordToFile(this.accountPassword);
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // account validator
    public boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.matches("^\\d{12}$");
    }

    public String generateAccountNumber(String customerName) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        String accountNumber = sb.toString();
        writeAccountNumberToFile(accountNumber, customerName);

        return accountNumber;
    }

    private void writeAccountNumberToFile(String accountNumber, String customerName) {
        try {
            String fileName = DIRECTORY_PATH + customerName + "_" + accountNumber.substring(8) + ".txt";

            // if not exist
            Path path = Paths.get(DIRECTORY_PATH);
            Files.createDirectories(path);

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(accountNumber + " : " + customerName + " : " + accountPassword + "\n");
            writer.close();

        } catch (IOException e) {
            System.err.println("error writing to file");
        }
    }

    public Map<Integer, String> getAccountDetails(String customerName, String lastFourDigits, String password) {
        if (!checkPassword(password)) {
            System.out.println("Invalid password. Access Denied");
            return null;
        }

        Map<Integer, String> accountDetails = new HashMap<>();
        try {
            String fileName = getFileName(customerName, lastFourDigits);

            FileReader fr = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(fr);

            String line;
            while ((line = bf.readLine()) != null) {
                String[] parts = line.split(" : ");
                if (parts.length == 2) {
                    int accountNumber = Integer.parseInt(parts[0].trim());
                    String customer = parts[1].trim();
                    accountDetails.put(accountNumber, customer);
                }
            }
            bf.close();
            fr.close();

        } catch (IOException | NumberFormatException e) {
            System.err.println("error reading the account");
        }
        return accountDetails;
    }

    private String getFileName(String customerName, String accountNumber) {
        return DIRECTORY_PATH + customerName + "_" + accountNumber.substring(accountNumber.length() - 4) + ".txt";
    }

    private boolean checkPassword(String password) {
        return password.equals(this.accountPassword);
    }

    private String generateDefaultPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private void writePasswordToFile(String password) {
        try {
            String fileName = DIRECTORY_PATH + ownerName + PASSWORD_FILE_SUFFIX;
            FileWriter writer = new FileWriter(fileName);
            writer.write(password);
            writer.close();
        } catch (IOException e) {
            System.err.println("error writing password: " + e.getMessage());
        }
    }

    public void setPassword(String newPassword) {
        this.accountPassword = newPassword;
        writePasswordToFile(newPassword);
        System.out.println("password changed successfully");
    }

    public String getPasswordFromFile() {
        try {
            String fileName = DIRECTORY_PATH + ownerName + PASSWORD_FILE_SUFFIX;
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String password = bufferedReader.readLine();
            bufferedReader.close();
            return password;
        } catch (IOException e) {
            System.err.println("error reading the password");
        }
        return "stored";
    }
}
