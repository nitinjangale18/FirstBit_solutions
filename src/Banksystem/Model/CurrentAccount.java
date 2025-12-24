package Banksystem.Model;


public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(int ac, String owner, double bal, double limit) {
        super(ac, owner, bal);
        this.overdraftLimit = limit;
        tm.add(new Transaction(ac, bal, "Initial Deposit", "Manual", "Success"));

    }

    public String getType() {
        return "Current";
    }

    public void printDetails() {
        System.out.println("\n[CURRENT ACCOUNT]");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Owner      : " + ownerName);
        System.out.println("Balance    : " + balance +
                " | Overdraft: " + overdraftLimit);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            tm.add(new Transaction(accountNumber, amount,
                    "Withdraw", "Manual", "Success"));
        } else {
            tm.add(new Transaction(accountNumber, amount,
                    "Withdraw", "Manual", "Failed-Overdraft"));
            System.out.println("Overdraft limit exceeded");
        }
    }
}

