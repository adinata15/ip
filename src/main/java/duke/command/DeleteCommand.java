package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.Ui;
import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.task.Task;
import main.java.duke.task.TaskList;

public class DeleteCommand extends Command {

    public DeleteCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyTaskListException{
        if(tasks.checkEmpty()){
            throw new EmptyTaskListException("your task list is empty");
        }
        //take word after "delete" as task index
        String taskIndexString = fullCommand.split(" ")[1];
        // convert taskIndexString into an integer
        int taskIndex = Integer.parseInt(taskIndexString);
        //leave out the removed task from list
        Task removedTask = tasks.remove(taskIndex);
        ui.displayDeleteMessage(removedTask);
    }

}