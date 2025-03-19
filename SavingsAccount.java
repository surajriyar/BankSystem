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
    }


