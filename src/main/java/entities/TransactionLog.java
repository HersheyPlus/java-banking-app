package entities;
import java.io.Serializable;

import static Helper.generateRandom.generateTransactionId;

public class TransactionLog implements Serializable {
    private final String transactionId;
    private final String log;
    private final double amount;
    public TransactionLog(String log ,double amount){
        this.transactionId = generateTransactionId();
        this.log = log;
        this.amount = amount;
    }

    public String getTransactionId() {
        return "Transaction Id:" + transactionId;
    }

    @Override
    public String toString() {
        return String.format("Transaction(transId:%s, log:%s, amount:%.2f)",transactionId,log,amount);
    }

}
