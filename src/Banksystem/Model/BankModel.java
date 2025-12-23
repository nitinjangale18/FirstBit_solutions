package Banksystem.Model;


import java.util.ArrayList;
import java.util.List;

public class BankModel {

    private List<Account> accounts = new ArrayList<>();

    public void add(Account a) {
        accounts.add(a);
    }

    public Account get(int ac) {
        for (Account a : accounts)
            if (a.accountNumber == ac)
                return a;
        return null;
    }

    public Account[] getAll() {
        return accounts.toArray(new Account[0]);
    }
    
    public boolean remove(int accNo) {
        Account a = get(accNo);
        if (a == null) return false;
        accounts.remove(a);
        return true;
    }

}

