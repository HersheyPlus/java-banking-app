package services;
import entities.Account;
import java.util.Collection;

public interface AccountService {
    public Account addAccount(Account account);
    public Account updateAccount(Account account);
    public Account findAccount(String accountId);
    public Account deleteAccount(String accountId);
    public int repoSize();
    public Collection<Account> allAccounts();

}
