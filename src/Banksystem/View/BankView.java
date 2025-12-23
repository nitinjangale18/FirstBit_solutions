package Banksystem.View;
import Banksystem.Controller.*;
import Banksystem.Model.*;
import java.util.*;



public class BankView {

	Scanner sc = new Scanner(System.in);
	BankController c = new BankController();
	boolean flag=true;
	public void start() {
		while (flag) {
			System.out.println("\n=== BANK MENU ===");
			System.out.println("1. Create Account");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Show Account");
			System.out.println("5. End of Day Report");
			System.out.println("6. Save Report");
			System.out.println("0. Exit");

			System.out.print("Choice: ");
			int ch = readInt();

			switch (ch) {
			case 1:
				createAccount();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withdraw();
				break;
			case 4:
				show();
				break;
			case 5:
				c.dailyReport();
				break;
			case 6:
				c.saveReport();
				break;
			case 0:
				flag=false;
				System.out.println("Terminating:Bye....");
				break;

			default:
				System.out.println("Invalid Choice");
			}
			
			

		}
		
		}

	int readInt() {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			return -1;
		}
	}

	double readDouble() {
		try {
			return Double.parseDouble(sc.nextLine());
		} catch (Exception e) {
			return 0;
		}
	}// Bank View class ends here

	/* ---------- CREATE ACCOUNT WITH TYPE INPUT ----------- */

	void createAccount() {
		System.out.println("\nEnter Account Type (savings/salary/current/loan): ");
		String type = sc.nextLine().toLowerCase();

		System.out.print("Account No: ");
		int ac = readInt();

		System.out.print("Owner Name: ");
		String name = sc.nextLine();

		switch (type) {

		case "savings":
			System.out.print("Initial Balance: ");
			double bal = readDouble();
			if (bal < 10000) {
			    System.out.println("Error: Minimum balance for savings account is 10000 Rs");
			    return; // or ask again
			}
			c.addAccount(new SavingsAccount(ac, name, bal, 1000, 5.5));
			break;
			
			
		case "current":
			System.out.print("Initial Balance: ");
			double bal2 = readDouble();
			c.addAccount(new CurrentAccount(ac, name, bal2, 10000));
			break;

		case "salary":
			System.out.print("Initial Balance: ");
			double bal3 = readDouble();
			c.addAccount(new SalaryAccount(ac, name, bal3, "Company", 50000));
			break;

		case "loan":
		    System.out.print("Loan Amount: ");
		    double loanAmt = readDouble();
		    c.addAccount(new LoanAccount(ac, name, loanAmt, 10, 12, "10th Every Month"));
		    break;

		default:
			System.out.println("Invalid Account Type");
		}
	}

	void deposit() {
		System.out.print("Account No: ");
		int ac = readInt();
		System.out.print("Amount: ");
		double amt = readDouble();
		c.deposit(ac,amt);
	}

	void withdraw() {
		System.out.print("Account No: ");
		int ac = readInt();
		System.out.print("Amount: ");
		double amt = readDouble();
		c.withdraw(ac, amt);
	}

	void show() {
	    System.out.print("Account No: ");
	    int ac = readInt();
	    Account a = c.find(ac);

	    if (a == null) {
	        System.out.println("Account Not Found");
	        return;
	    }

	    a.printDetails();

	    if (a instanceof SalaryAccount && ((SalaryAccount)a).isFrozen()) {
	        System.out.println("** This salary account is currently frozen due to inactivity **");
	    }

	    System.out.println("\nTransactions:");
	    a.printTransactions();
	}

}
