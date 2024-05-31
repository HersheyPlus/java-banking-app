package services;

import entities.Account;
import java.util.Collection;

public interface FileService {
    public  boolean WriteFile(Collection<Account> accounts);
    public boolean ReadFile();
}
