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
        this.lastTransaction = LocalDateTime.now(); // account creation counts
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

    // Update last transaction when deposit happens
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        lastTransaction = LocalDateTime.now();
    }

    // Update last transaction when withdraw happens
    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        lastTransaction = LocalDateTime.now();
    }

    // Check if account is frozen (no transaction in last 2 months)
    public boolean isFrozen() {
        return lastTransaction.plusSeconds(2).isBefore(LocalDateTime.now());
    }
}

/*
package Banksystem.Model;




 */

