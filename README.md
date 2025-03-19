// Base class for common account details
class Account {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Encapsulation: Getter and Setter methods
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + balance);
    }
}

// using inheritance for fetching the data
import java.io.*;
    // Derived class for saving account with additional methods
    class SavingsAccount extends Account {  //


        public SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
            super(accountNumber, accountHolder, initialBalance);
        }

        public void saveToFile() {
            try (FileWriter writer = new FileWriter("account_data.txt", true)) {
                writer.write("Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: $" + balance + "\n");
                System.out.println("Account details saved to file.");
            } catch (IOException e) {
                System.out.println("Error saving account data: " + e.getMessage());
            }
        }

// this is the main class
        import java.util.*;
public class BankSystem  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String accountHolder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        SavingsAccount account = new SavingsAccount(accountNumber, accountHolder, initialBalance);

        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    account.saveToFile();
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}




    }
