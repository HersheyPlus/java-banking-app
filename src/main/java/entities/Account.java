package entities;
import java.util.ArrayList;

import static Helper.generateRandom.*;
public class Account {
    private final String id;
    private final String accountId;
    private String accountPassword;
    private double balance;
    private String accountName;
    private final ArrayList<TransactionLog> allTransactionLogs = new ArrayList<>();

    public Account (String accountName, String accountPassword,double balance) {
        validateInputs(accountName, accountPassword, balance);
        this.allTransactionLogs.add(new TransactionLog("Create account and deposit",balance));
        this.accountId = generateAccountId();
        this.id = generateId();
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.balance = balance;
    }
    private void validateInputs(String accountName, String accountPassword, double balance) {
        if (accountName.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        if (accountPassword.isBlank()) {
            throw new IllegalArgumentException("Password must not be empty");
        }
        if (accountPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters");
        }
        if (balance <= 0) {
            throw new IllegalArgumentException("Balance must be more than 0");
        }
    }


    @Override
    public String toString() {
        return String.format("Account(id:%s, accountId:%s, name:%s, password:%s, balance:%.2f, number of " +
                        "transactions:%d)",id,
                accountId,
                accountName,accountPassword,balance,getTransactionSize());
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountPassword(String accountPassword) {
        if (accountPassword == null || accountPassword.isBlank() || accountPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters and not blank");
        }
        this.accountPassword = accountPassword;
    }

    public void setAccountName(String accountName) {
        if (accountName == null || accountName.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.accountName = accountName;
    }

    public boolean deposit(double amount) {
        if (amount <= 0.0) return false;
        balance += amount;
        allTransactionLogs.add(new TransactionLog("DEPOSIT",amount));
        return true;
    }
    public boolean withdraw(double amount) {
        if (amount <= 0.0 || amount > balance) return false;
        balance -= amount;
        allTransactionLogs.add(new TransactionLog("WITHDRAW",amount));
        return true;
    }

    public int getTransactionSize(){
        return allTransactionLogs.size();
    }
    public ArrayList<TransactionLog> getAllTransactionLogs() {
        return allTransactionLogs;
    }

}
