package polkAPI.tx;

public class SignException extends Exception {

    public SignException(String message) {
        this(message, null);
    }

    public SignException(String message, Throwable cause) {
        super(message, cause);
    }
}