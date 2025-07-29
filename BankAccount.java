import java.util.UUID;

public class BankAccount {
    private String accountHolderName;
    private String email;
    private String phone;
    private String bankName;
    private String accountNumber;
    private String accountId;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName, String email, String phone, String bankName) {
        this.accountHolderName = accountHolderName;
        this.email = email;
        this.phone = phone;
        this.bankName = bankName;
        this.accountNumber = generateAccountNumber();
        this.accountId = UUID.randomUUID().toString();
        this.balance = 0.0;
    }

    // Generate unique account number
    private String generateAccountNumber() {
        return "AC" + (int) (Math.random() * 900000 + 100000);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Bank: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account ID: " + accountId);
        System.out.println("Balance: $" + balance);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountId() {
        return accountId;
    }
}
