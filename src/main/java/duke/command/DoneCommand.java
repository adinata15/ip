package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.Ui;
import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.task.TaskList;

public class DoneCommand extends Command {

    public DoneCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Mark given task as done.
     *
     * @param tasks   current task list
     * @param ui      ui manager
     * @param storage file storage manager
     * @throws EmptyTaskListException task list is empty
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyTaskListException {
        if (tasks.checkEmpty()) {
            throw new EmptyTaskListException("your task list is empty");
        }
        //take word after "done" as task index
        String taskIndexString = fullCommand.split(" ")[1];
        // convert taskIndexString into an integer
        int taskIndex = Integer.parseInt(taskIndexString);
        //mark task as done
        tasks.getTask(taskIndex).markAsDone();
        tasks.getTask(taskIndex).printDoneMsg();
    }
}