package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.task.TaskList;
import main.java.duke.Ui;

public class ExitCommand extends Command {

    public ExitCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.displayByeMessage();
        setExit();
    }

}