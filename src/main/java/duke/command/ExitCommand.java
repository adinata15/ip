package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.task.TaskList;
import main.java.duke.Ui;

public class ExitCommand extends Command {

    public ExitCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Closes Duke and gives parting message.
     *
     * @param tasks   current task list
     * @param ui      ui manager
     * @param storage file storage manager
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.displayByeMessage();
        setExit();
    }

}