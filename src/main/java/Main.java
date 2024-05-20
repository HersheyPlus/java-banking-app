import entities.Account;
public class Main {
    public static void main(String[] args) {
        Account ac1 = new Account("Bomb","1234567",500);
        System.out.println("Create an account: " + ac1.toString());
        System.out.println(ac1.getAllTransactionLogs());
        System.out.println("Transaction initial size: " + ac1.getTransactionSize());
        System.out.println("Before deposit and withdraw: " + ac1.getBalance());
        ac1.deposit(100);
        ac1.deposit(200);
        ac1.deposit(300);
        ac1.deposit(400);
        ac1.withdraw(800);
        System.out.println("-------------------------------------");
        System.out.println(ac1.getAllTransactionLogs());
        System.out.println("Transaction current size: " + ac1.getTransactionSize());
        System.out.println("After deposit and withdraw: " + ac1.getBalance());
        System.out.println(ac1.getAllTransactionLogs());
    }
}
