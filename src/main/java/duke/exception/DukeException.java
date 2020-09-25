package main.java.duke.exception;

/**
 * Signals error when general error is encountered.
 */
public class DukeException extends Exception {
    public DukeException(String message) {
        super(message);
    }

}
