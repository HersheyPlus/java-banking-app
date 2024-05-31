package ui;
import java.util.Scanner;
public class UI {
    final static int MAX_ATTEMPTS = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int checkAttempt = 0;
        baseMenu();
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    createAccountUI();
                    break;
                case 2:
                    loginUI();
                    break;
                case 3:
                    System.out.println("-> Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    sc.nextLine();
                    checkAttempt++;
                    if (checkAttempt == MAX_ATTEMPTS) {
                        System.out.println("Too many invalid attempts. Exiting...");
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    public static void baseMenu() {
        System.out.println("---------- Welcome to Banking Application ----------");
        System.out.println("-> Choose an option (1,2,3)");
        System.out.println("1. Create an account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
    public static void createAccountUI() {
        Scanner sc = new Scanner(System.in);
        String name, password;
        double deposit;
        int checkBot = 0;
        System.out.println("-> Create an account <-");
        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine().trim();
            if (name.isBlank() || !name.matches("[a-zA-Z\\s]+")) {
                checkBot++;
                System.out.println("Name must not be empty or number. Please try again.");
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        checkBot = 0;
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine().trim();
            if (password.isBlank()) {
                checkBot++;
                System.out.println("Password must not be empty. Please try again.");
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        checkBot = 0;
        while (true) {
            System.out.print("Deposit: ");
            deposit = sc.nextDouble();
        if (deposit <= 0) {
                checkBot++;
                System.out.println("Deposit must > 0 or not be empty. Please try again.");
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        System.out.println("Account created successfully");
        checkBot = 0;
        continueUI(checkBot);
    }
    public static void loginUI(){
        Scanner sc = new Scanner(System.in);
        int checkBot = 0;
        String name, password;
        System.out.println("-> Login <-");
        while (true) {
            System.out.print("Name: ");
            name = sc.nextLine().trim();
            if (name.isBlank() || !name.matches("[a-zA-Z\\s]+")) {
                checkBot++;
                System.out.println("Name must not be empty or number. Please try again.");
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        checkBot = 0;
        while (true) {
            System.out.print("Password: ");
            password = sc.nextLine().trim();
            if (password.isBlank()) {
                checkBot++;
                System.out.println("Password must not be empty. Please try again.");
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                }
            } else {
                break;
            }
        }
        accountMenuUI();

    }

    public static void continueUI(int checkBot){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Do you want to continue ? ----------");
        while (true) {
            System.out.print("Enter your choice (y/n): ");
            String choice = sc.next();
            if (choice.equalsIgnoreCase("y")) {
                loginUI();
                break;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("-> Exit");
                System.exit(0);
            } else {
                checkBot++;
                if (checkBot >= MAX_ATTEMPTS) {
                    System.out.println("Too many invalid attempts. Exiting...");
                    System.exit(0);
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

            }
        }
    }
    public static void accountMenuUI() {
        Scanner sc = new Scanner(System.in);
        int checkBot = 0;
        int choice;
        System.out.println("---------- Account Menu ----------");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("Enter your choice (1,2,3,4): ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    depositUI();
                    break;
                case 2:
                    withdrawUI();
                    break;
                case 3:
                    transferUI();
                    break;
                case 4:
                    System.out.println("-> Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    sc.nextLine();
                    break;
            }
            checkBot++;
            if (checkBot >= MAX_ATTEMPTS) {
                System.out.println("Too many invalid attempts. Exiting...");
                System.exit(0);
            }
        }
    }
    public static void depositUI() {
        System.out.println("-> Deposit");
    }
    public static void withdrawUI() {
        System.out.println("-> Withdraw");
    }
    public static void transferUI() {
        System.out.println("-> Transfer");
    }
}
