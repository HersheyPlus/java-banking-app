package entities;
import exceptions.CreateAccountException;

import java.io.Serializable;
import java.util.ArrayList;

import static Helper.generateRandom.*;
public class Account implements Serializable {
    private final String accountId;
    private String accountPassword;
    private double balance;
    private String accountName;
    private final ArrayList<TransactionLog> allTransactionLogs = new ArrayList<>();
    private static int i = 1;
    private static final String finalId = "0";

    public Account (String accountName, String accountPassword,double balance) {
        validateInputs(accountName, accountPassword, balance);
        this.allTransactionLogs.add(new TransactionLog("Create account and deposit",balance));
        this.accountId = finalId + i;
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.balance = balance;
        i++;
    }
    private void validateInputs(String accountName, String accountPassword, double balance) {
        if (accountName == null || accountName.isBlank()) {
            throw new CreateAccountException("Name must not be empty");
        }
        if (accountPassword == null || accountPassword.isBlank()) {
            throw new CreateAccountException("Password must not be empty");
        }
        if (accountPassword.length() < 6) {
            throw new CreateAccountException("Password must be at least 6 characters");
        }
        if (balance <= 0) {
            throw new CreateAccountException("Balance must be more than 0");
        }
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
    public boolean transfer(Account targetAccount, double amount) {
        if (targetAccount == null || amount <= 0.0 || amount > balance) return false;
        balance -= amount;
        targetAccount.deposit(amount);
        allTransactionLogs.add(new TransactionLog("TRANSFER",amount));
        return true;
    }

    public int getTransactionSize(){
        return allTransactionLogs.size();
    }
    public ArrayList<TransactionLog> getAllTransactions() {
        return allTransactionLogs;
    }

    public Account cloneAccount(){
        return new Account(accountName, accountPassword, balance);
    }

    @Override
    public String toString() {
        return String.format("Account(accountId:%s, name:%s, password:%s, balance:%.2f, transactions:%d)",
                accountId,
                accountName,accountPassword,balance,getTransactionSize());
    }

}
