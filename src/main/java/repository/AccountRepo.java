package repository;

import entities.Account;
import services.AccountService;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import exceptions.*;
import services.FileService;

public class AccountRepo implements AccountService, Serializable {
    private final List<Account> accountRepo = new ArrayList<>();
    @Override
    public Collection<Account> getAllAccounts() {return accountRepo;}
    @Override
    public int getSize(){return accountRepo.size();}

    @Override
    public Account addAccount(String accountName, String accountPassword, double balance) {
        if (accountName == null || accountName.isBlank() || accountPassword == null ||
                accountPassword.isBlank() || balance <= 0) {
            throw new CreateAccountException("Creating account error");
        }
        Account account = new Account(accountName, accountPassword, balance);
        accountRepo.add(account);
        return account;
    }

    @Override
    public Account updateAccountName(String accountId, String newAccountName) {
        if (accountId == null || accountId.isBlank() || newAccountName == null || newAccountName.isBlank()) {
            throw new UpdateAccountException("Updating account name error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                account.setAccountName(newAccountName);
                return account;
            }
        }
        return null;
    }

    @Override
    public Account updateAccountPassword(String accountId, String newPassword) {
        if (accountId == null || accountId.isBlank() || newPassword == null ||newPassword.isBlank()) {
            throw new UpdateAccountException("Updating account password error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                account.setAccountPassword(newPassword);
                return account;
            }
        }
        return null;
    }

    @Override
    public Account findAccountById(String accountId) {
        if (accountId == null || accountId.isBlank()) {
            throw new FindAccountException("Finding account by id error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }


    @Override
    public Account findAccountByName(String accountName) {
        if (accountName == null ||accountName.isBlank()) {
            throw new FindAccountException("Finding account by name error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountName().equals(accountName)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Account deleteAccount(String accountId) {
        if (accountId == null || accountId.isBlank()) {
            throw new DeleteAccountException("Deleting account error");
        }
        System.out.println(accountId);
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                accountRepo.remove(account);
                return account;
            }
        }
        return null;
    }

    @Override
    public boolean deposit(String accountId, double money) {
        if (accountId == null || accountId.isBlank() || money <= 0) {
            throw new TransactionException("Depositing error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                account.deposit(money);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean withdraw(String accountId, double money) {
        if (accountId == null ||accountId.isBlank() || money <= 0) {
            throw new TransactionException("Withdrawing error");
        }
        for (Account account : accountRepo) {
            if (account.getAccountId().equals(accountId)) {
                account.withdraw(money);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean transfer(String accountId, String targetAccountId, double money) {
        if (accountId == null ||accountId.isBlank() || targetAccountId == null || targetAccountId.isBlank() || money <= 0) {
            throw new TransactionException("Transferring error");
        }
        Account account = findAccountById(accountId);
        Account targetAccount = findAccountById(targetAccountId);
        if (account == null || targetAccount == null) {
            return false;
        }
        account.transfer(targetAccount, money);
        return false;
    }


}
