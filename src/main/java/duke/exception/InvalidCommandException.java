package main.java.duke.exception;

/**
 * Signals error when user input invalid command.
 */
public class InvalidCommandException extends DukeException {
    public InvalidCommandException(String message) {
        super(message);
    }
}
