package ui;

import entities.Account;
import repository.AccountRepo;
import repository.FileRepo;


public class Main {
    public static void main(String[] args) {
        AccountRepo accService = new AccountRepo();
        FileRepo fileService = new FileRepo();
        accService.addAccount("Bomb","432lfsdfs",500);
        accService.addAccount("Best","vsmklvmkkp",1500);
        System.out.println(accService.getAllAccounts());
        System.out.println("--- Write file ---");
        fileService.WriteFile(accService.getAllAccounts());
        System.out.println("--- Read file ---");
        fileService.ReadFile();
    }
}
