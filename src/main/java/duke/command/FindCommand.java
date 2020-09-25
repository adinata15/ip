package main.java.duke.command;

import static java.util.stream.Collectors.toList;
import main.java.duke.Storage;
import main.java.duke.Ui;
import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.task.Task;
import main.java.duke.task.TaskList;

import java.util.ArrayList;
import java.util.List;

public class FindCommand extends Command {

    public FindCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws EmptyTaskListException {
        int reqDescriptionStartIndex = fullCommand.indexOf(" ") + 1;
        String reqDescription = fullCommand.substring(reqDescriptionStartIndex);
        ArrayList<Task> matchedTasks = filterTasks(reqDescription);
        Ui.showLine();
        //display matched description
        System.out.println(" Here are the matching tasks in your list:");
        for (int i = 0; i < matchedTasks.size(); i++) {
            matchedTasks.get(i).displayListPerTask(i);
        }
        Ui.showLine();
    }

    private ArrayList<Task> filterTasks(String reqDescription) {
        ArrayList<Task> matchTasks = (ArrayList<Task>) TaskList.getTasks().stream()
                .filter(task -> task.getDescription().contains(reqDescription)).collect(toList());
        return matchTasks;
    }
}