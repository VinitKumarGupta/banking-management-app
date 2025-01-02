import java.util.Random;
import java.util.Scanner;

abstract class BankAccount {
    int accountNumber;
    double balance = 0;

    void deposit(double amount) {
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Deducted $" + amount + " from your account.");
        } else {
            System.out.println("Not enough balance! Try again!");
        }
    }

    void checkBalance() {
        System.out.println("Your current balance is: $" + this.balance);
    }

    abstract void calculateInterest();
}

class SavingsAccount extends BankAccount {
    @Override
    void calculateInterest() {
        balance += balance * 0.03;
        System.out.println("Interest added: $" + (balance * 0.03));
    }
}

class CurrentAccount extends BankAccount {
    @Override
    void calculateInterest() {
        System.out.println("No interest for current accounts.");
    }
}

class Bank {
    static int totalAccounts = 0;
    static Random random = new Random();

    static int generateAccountNumber() {
        return 100000 + random.nextInt(900000);
    }

    static void incrementAccountCount() {
        totalAccounts++;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[100];  // Array to store all accounts
        // doesn’t create actual BankAccount objects yet.
        int accountIndex = 0;  // Tracks the number of accounts

        System.out.println("Welcome to the Vinit Gupta Banking System");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Create New Savings Account");
            System.out.println("2. Create New Current Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Display Total Accounts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    // Create a new savings account
                    SavingsAccount sa = new SavingsAccount();
                    sa.accountNumber = Bank.generateAccountNumber();
                    accounts[accountIndex] = sa;
                    Bank.incrementAccountCount();
                    System.out.println("Savings account created. Account Number: " + sa.accountNumber);
                    accountIndex++;
                    break;
                }
                case 2: {
                    // Create a new current account
                    CurrentAccount ca = new CurrentAccount();
                    ca.accountNumber = Bank.generateAccountNumber();
                    accounts[accountIndex] = ca;
                    Bank.incrementAccountCount();
                    System.out.println("Current account created. Account Number: " + ca.accountNumber);
                    accountIndex++;
                    break;
                }
                case 3: {
                    // Deposit money
                    System.out.print("Enter account number: ");
                    int accNum = scanner.nextInt();
                    BankAccount account = findAccount(accounts, accountIndex, accNum);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        account.deposit(amount);
                        System.out.println("Money deposited successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 4: {
                    // Withdraw money
                    System.out.print("Enter account number: ");
                    int accNum = scanner.nextInt();
                    BankAccount account = findAccount(accounts, accountIndex, accNum);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        account.withdraw(amount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 5: {
                    // Check balance
                    System.out.print("Enter account number: ");
                    int accNum = scanner.nextInt();
                    BankAccount account = findAccount(accounts, accountIndex, accNum);
                    if (account != null) {
                        account.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 6: {
                    // Calculate interest
                    System.out.print("Enter account number: ");
                    int accNum = scanner.nextInt();
                    BankAccount account = findAccount(accounts, accountIndex, accNum);
                    if (account != null) {
                        account.calculateInterest();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                }
                case 7: {
                    // Display total accounts
                    System.out.println("Total Accounts: " + Bank.getTotalAccounts());
                    break;
                }
                case 8: {
                    System.out.println("Thank you for using Vinit Gupta Bank!");
                    running = false;
                    break;
                }
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    // Helper function to find an account by account number
    private static BankAccount findAccount(BankAccount[] accounts, int accountIndex, int accountNumber) {
        for (int i = 0; i < accountIndex; i++) {
            if (accounts[i].accountNumber == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }
}
