package Banksystem.Model;


public class SavingsAccount extends Account {

    private double minBalance;
    private double interestRate;

    public SavingsAccount(int ac, String owner, double bal,
                          double minBal, double rate) {
        super(ac, owner, bal);
        this.minBalance = minBal;
        this.interestRate = rate;
        
        tm.add(new Transaction(ac, bal, "Initial Deposit", "Manual", "Success"));

    }

    public String getType() {
        return "Savings";
    }

    public void printDetails() {
        System.out.println("\n[SAVINGS ACCOUNT]");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Owner      : " + ownerName);
        System.out.println("Balance    : " + balance);
        System.out.println("Min Bal    : " + minBalance +
                " | Interest: " + interestRate + "%");
    }

    public void applyInterest() {
        double interest = balance * interestRate / 100.0;
        deposit(interest);
        System.out.println("Interest applied: " + interest);
    }
}
