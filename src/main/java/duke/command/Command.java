package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.exception.InvalidCommandException;
import main.java.duke.task.TaskList;
import main.java.duke.Ui;

public abstract class Command {
    private boolean isExit = false;
    protected String fullCommand;

    public Command(String fullCommand) {
        this.fullCommand = fullCommand;
    }

    protected void setExit() {
        isExit = true;
    }

    public boolean isExit() {
        return isExit;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws InvalidCommandException, EmptyTaskListException;


}