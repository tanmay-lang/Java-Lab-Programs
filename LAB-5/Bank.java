import java.util.Scanner;

class Account {
    protected String customerName;
    protected String accountNumber;
    protected double balance;
    protected String accountType;

    public Account(String customerName, String accountNumber, double initialBalance, String accountType) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawal operation not implemented in base class.");
    }
}

class SavAcct extends Account {
    private final double interestRate = 0.05; 

    public SavAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance, "Savings");
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of $" + interest + " deposited.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

class CurAcct extends Account {
    private final double minimumBalance = 1000.0;  
    private final double penalty = 50.0; 

    public CurAcct(String customerName, String accountNumber, double initialBalance) {
        super(customerName, accountNumber, initialBalance, "Current");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            if (balance < minimumBalance) {
                balance -= penalty;  
                System.out.println("Balance below minimum, penalty of $" + penalty + " imposed.");
            }
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name for the Savings Account: ");
        String name = scanner.nextLine();
        System.out.println("Enter initial balance for the Savings Account: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); 
        SavAcct savingsAccount = new SavAcct(name, "SA001", balance);

        System.out.println("Enter customer name for the Current Account: ");
        name = scanner.nextLine();
        System.out.println("Enter initial balance for the Current Account: ");
        balance = scanner.nextDouble();
        scanner.nextLine(); 
        CurAcct currentAccount = new CurAcct(name, "CA001", balance);

        System.out.println("\nPerforming operations on Savings Account");
        savingsAccount.displayBalance();
        savingsAccount.deposit(500);
        savingsAccount.displayBalance();
        savingsAccount.computeAndDepositInterest();
        savingsAccount.displayBalance();
        savingsAccount.withdraw(300);
        savingsAccount.displayBalance();

        System.out.println("\nPerforming operations on Current Account");
        currentAccount.displayBalance();
        currentAccount.deposit(200);
        currentAccount.displayBalance();
        currentAccount.withdraw(400);
        currentAccount.displayBalance();
        currentAccount.withdraw(1200); 
        currentAccount.displayBalance();

        scanner.close();
    }
}
