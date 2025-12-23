package Banksystem.Controller;

import Banksystem.Model.*;
import java.io.PrintWriter;

public class BankController {

    private BankModel model = new BankModel();


    public void addAccount(Account a) {
        if (model.get(a.getAccountNumber()) != null) {
            System.out.println("Account already exists");
            return;
        }
        model.add(a);
        System.out.println(" Account created successfully!");
    }

    public Account find(int ac) {
        return model.get(ac);
    }

    public void deposit(int ac, double amt) {
        Account a = find(ac);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        // Loan account → EMI payment
        if (a instanceof LoanAccount) {
            ((LoanAccount) a).payEmi(amt);
            return;
        }

        if (a instanceof SalaryAccount && ((SalaryAccount)a).isFrozen()) {
            System.out.println("Salary account frozen due to 2 months inactivity!");
            return;
        }

        a.deposit(amt);
        System.out.println("Transaction successful");
    }


    public void withdraw(int ac, double amt) {
        Account a = find(ac);
        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        if (a instanceof LoanAccount) {
            System.out.println("Withdrawals are not allowed from loan accounts");
            return;
        }

        if (a instanceof SalaryAccount && ((SalaryAccount)a).isFrozen()) {
            System.out.println("Salary account frozen due to 2 months inactivity!");
            return;
        }

        a.withdraw(amt);
        System.out.println("Transaction processed");
    }



    public void deleteAccount(int acNo) {
        boolean removed = model.remove(acNo);
        if (removed)
            System.out.println(" Account deleted successfully!");
        else
            System.out.println("Account not found");
    }


    public void applyInterestToSavings(int acNo) {
        Account a = find(acNo);
        if (a instanceof SavingsAccount)
            ((SavingsAccount) a).applyInterest();
        else
            System.out.println("Not a savings account.");
    }

    public void applyInterestToLoan(int acNo) {
        Account a = find(acNo);
        if (a instanceof LoanAccount)
            ((LoanAccount) a).applyInterest();
        else
            System.out.println("Not a loan account.");
    }

    public void payEmi(int acNo, double amt) {
        Account a = find(acNo);
        if (a instanceof LoanAccount)
            ((LoanAccount) a).payEmi(amt);
        else
            System.out.println("Not a loan account.");
    }


    public void dailyReport() {
        System.out.println("\n--- END OF DAY REPORT ---");

        Account[] allAccounts = model.getAll();
        double totalBalance = 0;
        int totalTransactions = 0;

        for (Account a : allAccounts) {
            a.printDetails();
            System.out.println("Transactions:");
            a.printTransactions();

            totalBalance += a.getBalance();
            totalTransactions += a.getTransactionManager().getTransactionCount();

            System.out.println("--------------------------");
        }

        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total Accounts: " + allAccounts.length);
        System.out.println("Total Balance: " + totalBalance);
        System.out.println("Total Transactions: " + totalTransactions);
    }
    
    
    
    public void saveReport() {
        try (PrintWriter pw = new PrintWriter("EndOfDayReport.txt")) {

            pw.println("END OF DAY REPORT");
            pw.println("==============================");

            for (Account a : model.getAll()) {
                pw.println(a.getType() + " Account: " + a.getAccountNumber());
                pw.println("Owner: " + a.getOwnerName());
                pw.println("Balance: " + a.getBalance());
                
                
            }

            System.out.println("Report saved to EndOfDayReport.txt");

        } catch (Exception e) {
            System.out.println("Error saving report");
        }
    }
    
    /*

    public void saveReport() {
        System.out.println("END OF DAY REPORT\n==============================\n");

        for (Account a : model.getAll()) {
            System.out.println(a.getType() + " Account: " + a.getAccountNumber());
            System.out.println("Owner: " + a.getOwnerName());
            System.out.println("Balance: " + a.getBalance());
            System.out.println("Transactions:");
            a.printTransactions();
            System.out.println("-----------------------------\n");
        }

        System.out.println(" Report displayed on console");
    }*/
}
