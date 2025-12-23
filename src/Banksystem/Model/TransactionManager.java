package Banksystem.Model;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private List<Transaction> list = new ArrayList<>();

    public void add(Transaction t) {
        list.add(t);
    }

    public void printAll() {
        if (list.isEmpty())
            System.out.println("No transactions.");
        else
            for (Transaction t : list)
                t.print();
    }

    public int getTransactionCount() {
        return list.size();
    }
}
