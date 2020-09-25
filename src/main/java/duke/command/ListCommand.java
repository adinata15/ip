package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.Ui;
import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.task.TaskList;

public class ListCommand extends Command {

    public ListCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Lists current task list.
     *
     * @param tasks   current task list
     * @param ui      ui manager
     * @param storage file storage manager
     * @throws EmptyTaskListException  if task list is empty
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyTaskListException {
        if (tasks.checkEmpty()) {
            throw new EmptyTaskListException("your task list is empty");
        }
        ui.displayList();
    }

}