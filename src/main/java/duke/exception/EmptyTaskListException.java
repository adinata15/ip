package main.java.duke.exception;

/**
 * Signals error when task list is empty.
 */
public class EmptyTaskListException extends DukeException {
    public EmptyTaskListException(String message) {
        super(message);
    }
}
