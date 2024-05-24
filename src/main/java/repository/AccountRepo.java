package repository;

import entities.Account;
import services.AccountService;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class AccountRepo implements AccountService {
    private final List<Account> repo = new ArrayList<>();
    @Override
    public Account addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        repo.add(account);
        System.out.printf("-> Add successfully, accountId:%s%n", account.getAccountId());
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        for (int i = 0; i < repo.size(); i++) {
            if (repo.get(i).getAccountId().equals(account.getAccountId())) {
                repo.set(i, account);
                System.out.printf("-> Update successfully, accountId:%s%n",repo.get(i).getAccountId());
                return account;
            }
        }
        return null;
    }

    @Override
    public Account findAccount(String accountId) {
        for (Account account : repo) {
            if (account.getAccountId().equals(accountId)) {
                System.out.println("-> Found accountId: " + account.getAccountId() + " Name: " + account.getAccountName());
                return account;
            }
        }
        System.out.println("Not found accountId:" + accountId);
        return null;
    }

    @Override
    public Account deleteAccount(String accountId) {
        for (int i = 0; i < repo.size(); i++) {
            if (repo.get(i).getAccountId().equals(accountId)) {
                System.out.println("-> Remove successfully, accountId: " + accountId + " Name: " + repo.get(i).getAccountName());
                return repo.remove(i);
            }
        }
        return null;
    }

    @Override
    public Collection<Account> allAccounts() {
        return repo;
    }
    @Override
    public int repoSize(){
        return repo.size();
    }
}
