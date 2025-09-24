import java.util.Scanner;

// Step 4: BankAccount class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("⚠️ Deposit amount must be positive.");
        } else {
            balance += amount;
            System.out.printf("✅ Successfully deposited %.2f. New balance: %.2f\n", amount, balance);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("⚠️ Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient balance! Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.printf("✅ Successfully withdrew %.2f. New balance: %.2f\n", amount, balance);
        }
    }
}

// Step 1: ATM class
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    // Step 2: User Interface
    public void start() {
        System.out.println("💳 Welcome to the ATM Machine!");

        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. 💵 Withdraw");
            System.out.println("2. 💰 Deposit");
            System.out.println("3. 🧾 Check Balance");
            System.out.println("4. ❌ Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = getValidIntegerInput();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    handleCheckBalance();
                    break;
                case 4:
                    System.out.println("👋 Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("⚠️ Invalid option. Please choose 1-4.");
            }
        }
    }

    // Step 3: ATM Methods
    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidDoubleInput();
        account.withdraw(amount);
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidDoubleInput();
        account.deposit(amount);
    }

    private void handleCheckBalance() {
        System.out.printf("Your current balance is: %.2f\n", account.getBalance());
    }

    // Step 6: Input Validation
    private int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("⚠️ Invalid input. Please enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }

    private double getValidDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("⚠️ Invalid input. Please enter a valid amount: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextDouble();
    }
}

// Main class to run everything
public class ATMApp {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(10000.0); // You can ask user input here if needed

        // Create ATM with the user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM interface
        atm.start();
    }
}
