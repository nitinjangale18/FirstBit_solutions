package Banksystem.Model;

public abstract class Account {

    protected int accountNumber;
    protected String ownerName;
    protected double balance;

    protected TransactionManager tm = new TransactionManager();
    
    
    
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }


    public Account(int ac, String owner, double bal) {
        this.accountNumber = ac;
        this.ownerName = owner;
        this.balance = bal;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        balance += amount;
        tm.add(new Transaction(accountNumber, amount, "Deposit", "Manual", "Success"));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (balance >= amount) {
            balance -= amount;
            tm.add(new Transaction(accountNumber, amount, "Withdraw", "Manual", "Success"));
        } else {
            System.out.println("Insufficient balance");
            tm.add(new Transaction(accountNumber, amount, "Withdraw", "Manual", "Failed"));
        }
    }

    public void printTransactions() {
        tm.printAll();
    }

    public TransactionManager getTransactionManager(){
        return tm;
    }

    public abstract String getType();
    public abstract void printDetails();
}
