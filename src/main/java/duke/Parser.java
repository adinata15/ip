package main.java.duke;

import main.java.duke.command.AddCommand;
import main.java.duke.command.Command;
import main.java.duke.command.DeleteCommand;
import main.java.duke.command.DoneCommand;
import main.java.duke.command.ExitCommand;
import main.java.duke.command.FindCommand;
import main.java.duke.command.ListCommand;
import main.java.duke.exception.InvalidCommandException;


public class Parser {

    //handle user input commands
    public static Command parse(String fullCommand) throws InvalidCommandException {
        //execute command based on user's input until "bye" is entered
        if (fullCommand.equals("bye")) {
            return new ExitCommand(fullCommand);
        } else if (fullCommand.equals("list")) {
            return new ListCommand(fullCommand);
        } else if (fullCommand.startsWith("done")) {
            return new DoneCommand(fullCommand);
        } else if (fullCommand.startsWith("find")) {
            return new FindCommand(fullCommand);
        } else if (fullCommand.startsWith("delete")) {
            return new DeleteCommand(fullCommand);
        } else if (
                fullCommand.startsWith("deadline") ||
                        fullCommand.startsWith("event") ||
                        fullCommand.startsWith("todo")) {
            return new AddCommand(fullCommand);
        } else {
            throw new InvalidCommandException("I do not understand that command :(");
        }
    }
}