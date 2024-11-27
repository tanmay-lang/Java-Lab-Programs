import java.util.Scanner;

abstract class Account {
    String name, accNo;
    double balance;

    Account(String name, String accNo, double balance) {
        this.name = name;
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

    abstract void withdraw(double amount);
}

class SavAcct extends Account {
    SavAcct(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }

    void computeInterest() {
        balance += balance * 0.05;
        System.out.println("Interest added.");
    }

    void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance.");
    }
}

class CurAcct extends Account {
    CurAcct(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            if (balance < 1000) balance -= 50; // Penalty
        } else System.out.println("Insufficient balance.");
    }
}

public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name and balance for Savings Account: ");
        SavAcct sa = new SavAcct(sc.next(), "SA001", sc.nextDouble());
        System.out.print("Enter name and balance for Current Account: ");
        CurAcct ca = new CurAcct(sc.next(), "CA001", sc.nextDouble());

        System.out.println("\nSavings Account Operations:");
        sa.deposit(500);
        sa.computeInterest();
        sa.withdraw(300);
        sa.displayBalance();

        System.out.println("\nCurrent Account Operations:");
        ca.deposit(200);
        ca.withdraw(400);
        ca.withdraw(1200);
        ca.displayBalance();

        sc.close();
    }
}
