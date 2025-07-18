import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    protected int balance;
    protected String accountHolder;
    protected String ifsc;
    protected String accountType;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account() {
        this("N/A", 0, "UNKNOWN");
    }

    public Account(String accountHolder, int balance, String ifsc) {
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.ifsc = ifsc;
        this.accountType="Generic";
    }

    public void deposit(int amount) {
        if (amount < 1) {
            System.out.println("Invalid amount! Please enter a positive value.");
        } else {
            balance += amount;
            System.out.println("Deposit of INR " + amount + " is successful!");
            transactionHistory.add("Deposited INR " + amount);
        }
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of INR " + amount + " is successful!");
            transactionHistory.add("Withdrew INR " + amount);
        }
    }

    public int getBalance() {
        transactionHistory.add("Checked balance: INR " + balance);
        return balance;
    }

    public void displayDetails() {
        System.out.println("\nAccount Holder Name: " + accountHolder);
        System.out.println("Balance: INR " + balance);
        System.out.println("Branch IFSC Code: " + ifsc);
        System.out.println("Account type: " + accountType);
    }

    public void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("\nNo transactions have been made yet.");
        } else {
            System.out.println("\nTransaction History:");
            for (String record : transactionHistory) {
                System.out.println("- " + record);
            }
        }
    }
}

class SavingsAccount extends Account {
    private static final int MIN_BALANCE = 5000;

    public SavingsAccount(String accountHolder, int balance, String ifsc) {
        super(accountHolder, balance, ifsc);
        this.accountType= "Savings";
    }

    @Override
    public void withdraw(int amount) {
        if (amount < 1) {
            System.out.println("Invalid amount! Must be greater than 0.");
        } else if ((balance - amount) < MIN_BALANCE) {
            System.out.println("Withdrawal request denied!");
            System.out.println("Note: A minimum balance of INR " + MIN_BALANCE + " must be maintained.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal of INR " + amount + " is successful!");
            transactionHistory.add("Withdrew INR " + amount);
        }
    }
}

public class BankApp {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("----- Welcome to Bank Management System -----");
        System.out.println("\nPlease submit the details to avail the services of account instantly...");

        String name;
        while (true) {
            System.out.print("\nEnter Account Holder Name: ");
            name = sc.nextLine().trim();
            if (!name.isEmpty()) break;
            System.out.println("Name cannot be empty. Please try again.");
        }

        int initialBalance = 0;
        while (true) {
            try {
                System.out.print("Enter deposit amount (minimum INR 5000): ");
                initialBalance = Integer.parseInt(sc.nextLine().trim());
                if (initialBalance < 5000) {
                    System.out.println("Initial balance must be at least INR 5000.");
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        String ifsc;
        while (true) {
            System.out.print("Enter Branch IFSC Code: ");
            ifsc = sc.nextLine().trim().toUpperCase();
            if (!ifsc.isEmpty()) break;
            System.out.println("IFSC code cannot be empty. Please try again.");
        }

        System.out.println("\nThank you for providing the Details!");

        Account account = new SavingsAccount(name, initialBalance, ifsc);
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("\n-- Application Menu --");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Account Details");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            String input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("No input detected. Please enter a valid number (1-6)");
                continue;
            }

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a numeric value.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("\nEnter amount to deposit: ");
                    try {
                        int depositAmount = Integer.parseInt(sc.nextLine().trim());
                        account.deposit(depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                    }
                }
                case 2 -> {
                    System.out.print("\nEnter amount to withdraw: ");
                    try {
                        int withdrawAmount = Integer.parseInt(sc.nextLine().trim());
                        account.withdraw(withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount! Please enter a valid number.");
                    }
                }
                case 3 -> System.out.println("\nCurrent Balance: INR " + account.getBalance());
                case 4 -> account.displayDetails();
                case 5 -> account.viewTransactionHistory();
                case 6 -> {
                    System.out.println("\nThank you for using Bank Management Application!");
                    System.out.println("Please visit again.\nExiting...");
                    continueApp = false;
                    break;
                }
                
                default -> System.out.println("Invalid input! Please select a valid option (1-6).");
            }

            if (continueApp) {
                System.out.print("\nDo you want to continue? (y/n): ");
                String again = sc.nextLine().trim().toLowerCase();
                if (!again.equals("y")) {
                    System.out.println("\nThank you for using Bank Management Application!");
                    System.out.println("Please visit again.\nExiting...");
                    break;
                }
            }
        }

        sc.close();
    }
}
