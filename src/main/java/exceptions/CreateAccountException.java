package exceptions;

public class CreateAccountException extends RuntimeException{
    public CreateAccountException(String message) {
        super(message);
    }
}
