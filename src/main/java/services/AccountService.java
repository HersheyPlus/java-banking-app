package services;

import entities.Account;

public interface AccountService {
    public Account addAccount(String accountId);
    public Account updateAccount(Account accountId);
    public Account findAccount(String accountId);
    public Account deleteAccount(String accountId);
}
