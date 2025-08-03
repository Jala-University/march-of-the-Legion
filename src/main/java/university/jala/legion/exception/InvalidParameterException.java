package university.jala.legion.exception;

/**
 * Custom exception for handling invalid command-line parameters.
 * Provides clear and specific error messages.
 */
public class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }
}