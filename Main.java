import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n===== Account Management System =====");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Bank Name: ");
                    String bank = scanner.nextLine();

                    BankAccount newAccount = new BankAccount(name, email, phone, bank);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully!");
                    System.out.println("Account ID: " + newAccount.getAccountId());
                    System.out.println("Account Number: " + newAccount.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNumDeposit = scanner.nextLine();
                    BankAccount accDeposit = findAccount(accounts, accNumDeposit);
                    if (accDeposit != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        accDeposit.deposit(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String accNumWithdraw = scanner.nextLine();
                    BankAccount accWithdraw = findAccount(accounts, accNumWithdraw);
                    if (accWithdraw != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        accWithdraw.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String accNumView = scanner.nextLine();
                    BankAccount accView = findAccount(accounts, accNumView);
                    if (accView != null) {
                        accView.displayAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the Account Management System!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    // Helper method to find account by account number
    private static BankAccount findAccount(ArrayList<BankAccount> accounts, String accNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accNumber)) {
                return account;
            }
        }
        return null;
    }
}
