import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final BankImplementation bank = new BankImplementation();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addAccount();
                    break;
                case 2:
                    removeAccount();
                    break;
                case 3:
                    getAccountDetails();
                    break;
                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid choice");
            }
        }
        System.out.println("Thank you for using our bank services.");
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("Welcome to DevEnv bank");
        System.out.println("1. Add Account");
        System.out.println("2. Remove Account");
        System.out.println("3. Get Account Details");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    private static void addAccount() {
        System.out.println("Account type: Savings or Current");

        System.out.println("Enter your name: ");
        String customerName = sc.nextLine();

        System.out.println("Enter your phone number: ");
        int phoneNumber = sc.nextInt();

    }

    private static void removeAccount() {

    }

    private static void getAccountDetails() {

    }
}
