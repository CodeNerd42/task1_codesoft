import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void displayMenu() {
        System.out.println("ATM MENU");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + bankAccount.getBalance());
    }

    public void deposit(double amount) {
        if (amount > 0) {
            bankAccount.deposit(amount);
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}

public class ATMJava {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting ATM. Have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
