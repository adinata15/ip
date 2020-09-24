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

public class AddCommand extends Command {

    public AddCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            //first word of user's input
            String commandType = fullCommand.split(" ")[0];
            if (fullCommand.split(" ")[1].isEmpty()) {
                throw new InvalidCommandException("Something is missing in your command");
            }
            int descriptionStartIndex = fullCommand.indexOf(" ") + 1;
            int descriptionEndIndex = fullCommand.indexOf("/");
            String description = descriptionEndIndex == -1 ?
                    fullCommand.substring(descriptionStartIndex) :
                    fullCommand.substring(descriptionStartIndex, descriptionEndIndex);
            String time;
            Task newTask;
            //create task type based on user input
            switch (commandType) {
            case "todo":
                newTask = new ToDo(description, TaskType.TODO);
                break;
            case "deadline":
                time = fullCommand.split("/by")[1];
                newTask = new Deadline(description, TaskType.DEADLINE, time);
                break;
            case "event":
                time = fullCommand.split("/at")[1];
                newTask = new Event(description, TaskType.EVENT, time);
                break;
            default:
                throw new InvalidCommandException("I don't understand that :(");
            }
            TaskList.addTasks(newTask);
            storage.saveData();
            newTask.respondOnAdd();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Some parts of the command are missing");
        } catch (InvalidCommandException e) {
            e.printStackTrace();
        }
    }
}