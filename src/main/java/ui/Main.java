package ui;

import entities.Account;
import repository.AccountRepo;

import java.lang.management.GarbageCollectorMXBean;

public class Main {
    public static void main(String[] args) {
        AccountRepo accRepo = new AccountRepo();
        Account ac1 = new Account("Bomb","bomb111",500);
        Account ac2 = new Account("Best","best222",600);
        Account ac3 = new Account("Tune","tune333",700);
        Account ac4 = new Account("Fah","fah444",800);
        Account ac5 = new Account("Karn","karn555",900);
        System.out.println("----------  Add account ----------");
        accRepo.addAccount(ac1);
        accRepo.addAccount(ac2);
        accRepo.addAccount(ac3);
        accRepo.addAccount(ac4);
        accRepo.addAccount(ac5);
        System.out.println("Repo current size: " + accRepo.repoSize());
        System.out.println(accRepo.allAccounts());
        System.out.println("\n---------- Update account ---------- ");
        ac1.setAccountName("new Bomb");
        ac1.setAccountPassword("New Bomb Password");
        ac1.deposit(800);
        accRepo.updateAccount(ac1);
        System.out.println("Repo current size: " + accRepo.repoSize());
        System.out.println(accRepo.allAccounts());
        System.out.println("\n---------- Find account ---------- ");
        accRepo.findAccount(ac1.getAccountId());
        accRepo.findAccount(ac2.getAccountId());
        System.out.println("Repo current size: " + accRepo.repoSize());
        System.out.println(accRepo.allAccounts());
        System.out.println("\n----------  Delete account ----------");
        accRepo.deleteAccount(ac1.getAccountId());
        System.out.println("Repo current size: " + accRepo.repoSize());
        System.out.println(accRepo.allAccounts());

    }
}
