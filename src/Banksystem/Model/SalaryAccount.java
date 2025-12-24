package Banksystem.Model;

import java.time.LocalDateTime;

public class SalaryAccount extends Account {

    private String employerName;
    private double salaryLimit;
	private LocalDateTime lastTransaction;

    public SalaryAccount(int ac, String owner, double bal,
                         String emp, double limit) {
        super(ac, owner, bal);
        this.employerName = emp;
        this.salaryLimit = limit;
        this.lastTransaction = LocalDateTime.now();
        
        tm.add(new Transaction(ac, bal, "Initial Salary Credit", "Manual", "Success"));

    }

    public String getType() {
        return "Salary";
    }

    public void printDetails() {
        System.out.println("\n[SALARY ACCOUNT]");
        System.out.println("Account No : " + accountNumber);
        System.out.println("Owner      : " + ownerName);
        System.out.println("Balance    : " + balance);
        System.out.println("Employer   : " + employerName +
                " | Limit: " + salaryLimit);
        
        if (isFrozen()) {
            System.out.println("** ACCOUNT FROZEN DUE TO INACTIVITY **");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        lastTransaction = LocalDateTime.now();
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        lastTransaction = LocalDateTime.now();
    }

    public boolean isFrozen() {
        return lastTransaction.plusSeconds(2).isBefore(LocalDateTime.now());
    }
}



