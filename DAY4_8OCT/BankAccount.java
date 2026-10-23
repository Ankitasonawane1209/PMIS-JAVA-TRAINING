//bank Account management system

package DAY4_8OCT;

public class BankAccount {

    String accountholder;
    double balance;

    // Constructor
    BankAccount(String accountholder, double balance) {
        this.accountholder = accountholder;
        this.balance = balance;
    }

    // Deposit
    void deposit(double amount) {
        balance += amount;

        System.out.println("Deposited: " + amount);
        System.out.println("New Balance: " + balance);
    }

    // Withdraw
    void withdraw(double amount) {

        if (amount <= balance) {
            balance -= amount;

            System.out.println("Withdrawal: " + amount);
            System.out.println("Updated Balance: " + balance);
        } 
        else {
            System.out.println("Insufficient balance");
        }
    }

    // Display account information
    void displayInfo() {
        System.out.println("Account Holder: " + accountholder);
        System.out.println("Balance: " + balance);
    }

    // Main method
    public static void main(String[] args) {

        BankAccount account1 = new BankAccount("Ankita", 10000);

        account1.displayInfo();

        account1.deposit(2000);

        account1.withdraw(3000);

        account1.withdraw(15000);
    }
}