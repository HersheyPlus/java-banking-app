package Helper;
import java.util.Random;
public class generateRandom {

    private static final String NUMBERS = "0123456789";
    private static final String CHARSANDNUMS = "1234567890abcdef";
    private static final Random random = new Random();
    public static String generateId() {
        StringBuilder id = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(CHARSANDNUMS.length());
            id.append(CHARSANDNUMS.charAt(index));
        }
        return id.toString();
    }
    public static String generateAccountId() {
        StringBuilder accountId = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(NUMBERS.length());
            accountId.append(NUMBERS.charAt(index));
        }
        return accountId.toString();
    }
    public static String generateAccountIdV2() {
        StringBuilder accountId = new StringBuilder(9);
        for (int i = 0; i < 9; i++) {
            int index = random.nextInt(NUMBERS.length());
            accountId.append(NUMBERS.charAt(index));
        }
        return accountId.toString();
    }
    public static String generateTransactionId() {
        StringBuilder transactionId = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(NUMBERS.length());
            transactionId.append(NUMBERS.charAt(index));
        }
        return transactionId.toString();
    }
}
