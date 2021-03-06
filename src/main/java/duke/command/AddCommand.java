package main.java.duke.command;

import main.java.duke.Storage;
import main.java.duke.exception.InvalidCommandException;
import main.java.duke.task.Deadline;
import main.java.duke.task.Event;
import main.java.duke.task.Task;
import main.java.duke.task.TaskList;
import main.java.duke.Ui;
import main.java.duke.task.TaskType;
import main.java.duke.task.ToDo;

import java.time.LocalDate;

/**
 * Handles "add" command
 */
public class AddCommand extends Command {

    public AddCommand(String fullCommand) {
        super(fullCommand);
    }

    /**
     * Add input task to task list.
     *
     * @param tasks   current task list
     * @param ui      ui manager
     * @param storage file storage manager
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            //first word of user's input
            String commandType = fullCommand.split(" ")[0];
            if (fullCommand.split(" ")[1].isEmpty()) {
                throw new InvalidCommandException("Something is missing in your command");
            }
            String description = extractDescription();
            Task newTask = identifyCommand(commandType, description);
            TaskList.addTasks(newTask);
            storage.saveData();
            newTask.respondOnAdd();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Some parts of the command are missing");
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }

    private Task identifyCommand(String commandType, String description) throws InvalidCommandException {
        Task newTask;
        LocalDate time;
        //create task type based on user input
        switch (commandType) {
        case "todo":
            newTask = new ToDo(description, TaskType.TODO);
            break;
        case "deadline":
            time = LocalDate.parse(fullCommand.split("/by")[1].trim());
            newTask = new Deadline(description, TaskType.DEADLINE, time);
            break;
        case "event":
            time = LocalDate.parse(fullCommand.split("/at")[1].trim());
            newTask = new Event(description, TaskType.EVENT, time);
            break;
        default:
            throw new InvalidCommandException("I don't understand that :(");
        }
        return newTask;
    }

    private String extractDescription() {
        int descriptionStartIndex = fullCommand.indexOf(" ") + 1;
        int descriptionEndIndex = fullCommand.indexOf("/");
        return descriptionEndIndex == -1 ?
                fullCommand.substring(descriptionStartIndex) : //for todo
                fullCommand.substring(descriptionStartIndex, descriptionEndIndex); //for event and deadline
    }
}