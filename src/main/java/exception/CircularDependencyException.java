package exception;

public class CircularDependencyException extends Exception {

    public CircularDependencyException(String message) {
        super(message);
    }

    public CircularDependencyException() {
        super();

    }
}
