package Banksystem.Model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private int accountNo;
    private double amount;
    private String type;
    private String mode;
    private String status;
    private String dateTime;

    public Transaction(int accountNo, double amount, String type, String mode, String status) {
        this.accountNo = accountNo;
        this.amount = amount;
        this.type = type;
        this.mode = mode;
        this.status = status;
        this.dateTime = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "Transaction [accountNo=" + accountNo +
                ", amount=" + amount +
                ", type=" + type +
                ", mode=" + mode +
                ", status=" + status +
                ", dateTime=" + dateTime + "]";
    }

    public void print() {
        System.out.println(this);
    }
}
