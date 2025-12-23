package Banksystem.Model;


public class LoanAccount extends Account {

    private double loanAmount;
    private double interestRate;
    private double emi;
    private String dueDate;
    private int tenureMonths;   // ✅ ADD THIS LINE


    public LoanAccount(int ac, String owner, double loanAmt,
            double rate, int tenureMonths, String dueDate) {

super(ac, owner, -loanAmt);   // loan = negative balance

this.loanAmount = loanAmt;
this.interestRate = rate;
this.tenureMonths = tenureMonths;
this.dueDate = dueDate;

// ✅ EMI calculation (CORRECT PLACE)
double totalPayable = loanAmt + (loanAmt * rate / 100);
this.emi = totalPayable / tenureMonths;
}
    public String getType() {
        return "Loan";
    }

    public void printDetails() {
        System.out.println("\n[LOAN ACCOUNT]");
        System.out.println("Account No       : " + accountNumber);
        System.out.println("Owner            : " + ownerName);
        System.out.println("Outstanding Loan : " + (-balance));
        System.out.println("Interest         : " + interestRate +
                "% | EMI: " + emi + " | Due: " + dueDate);
    }

    public void applyInterest() {
        double interest = (-balance) * interestRate / 100.0;
        balance -= interest;
        tm.add(new Transaction(accountNumber, interest,
                "Interest", "System", "Success"));
        System.out.println("Loan interest charged: " + interest);
    }

    public void payEmi(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid EMI");
            return;
        }

        if (balance >= 0) {
            System.out.println("Loan already fully paid");
            return;
        }

        balance += amount;

        if (balance > 0) {
            balance = 0;
            System.out.println("Loan fully cleared!");
        }

        tm.add(new Transaction(accountNumber, amount,
                "EMI", "Manual", "Success"));

        System.out.println("EMI paid: " + amount);
    }
}

