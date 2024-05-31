package services;
import entities.Account;
import java.util.Collection;

public interface AccountService {
    public Account addAccount(String accountName, String accountPassword, double balance);
    public Account updateAccountName(String accountId, String newAccountName);
    public Account updateAccountPassword(String accountId, String newPassword);
    public Account findAccountById(String accountId);
    public Account findAccountByName(String accountName);
    public Account deleteAccount(String accountId);
    public boolean deposit(String accountId, double money);
    public boolean withdraw(String accountId, double money);
    public boolean transfer(String accountId, String targetAccountId, double money);
    public int getSize();
    public Collection<Account> getAllAccounts();

}
