import java.util.ArrayList;
import java.util.Scanner;

// Class representing an ATM
class Atm {
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize ATM with balance and PIN
    public Atm(double balance, String pin) {
        this.balance = balance;
        this.pin = pin;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to check balance
    public double checkBalance() {
        return balance;
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: $" + amount);
            System.out.println("Withdrawal successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: $" + amount);
            System.out.println("Deposit successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Method to change PIN
    public void changePIN(String newPIN) {
        this.pin = newPIN;
        System.out.println("PIN changed successfully.");
    }

    // Method to display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Method to validate PIN
    public boolean validatePIN(String enteredPIN) {
        return pin.equals(enteredPIN);
    }
}

// Main class to run the ATM program
public class UsedAtm{
    public static void main(String[] args) {
        Atm atm = new Atm(1000.0, "7524");  // Initialize ATM with initial balance and PIN

        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;

        System.out.println("Welcome to the ATM.");
        System.out.print("Enter your PIN: ");
        String enteredPIN = scanner.nextLine();

        // Validate PIN
        authenticated = atm.validatePIN(enteredPIN);

        if (authenticated) {
            int choice;
            do {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Balance Inquiry");
                System.out.println("2. Withdrawal");
                System.out.println("3. Deposit");
                System.out.println("4. Change PIN");
                System.out.println("5. Transaction History");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline character

                switch (choice) {
                    case 1:
                        System.out.println("Your balance is: $" + atm.checkBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter new PIN: ");
                        String newPIN = scanner.nextLine();
                        atm.changePIN(newPIN);
                        break;
                    case 5:
                        atm.displayTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        } else {
            System.out.println("Invalid PIN. Access denied.");
        }

        scanner.close();
    }
}