package exceptions;

public class UpdateAccountException extends RuntimeException{
    public UpdateAccountException(String message) {
        super(message);
    }
}
