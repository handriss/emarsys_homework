package exception;

public class InvalidLocationNameException extends Exception{

    public InvalidLocationNameException(String message) {
        super(message);
    }

    public InvalidLocationNameException() {
        super();

    }
}