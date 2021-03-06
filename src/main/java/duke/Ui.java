package main.java.duke;

import main.java.duke.exception.EmptyTaskListException;
import main.java.duke.task.Task;
import main.java.duke.task.TaskList;

import java.util.Scanner;

/**
 * Handles interaction with user.
 */
public class Ui {

    /**
     * Display current task list
     *
     * @throws EmptyTaskListException if task list is empty
     */
    public void displayList() throws EmptyTaskListException {
        if (TaskList.getTasks() == null) {
            throw new EmptyTaskListException("Your task list is empty");
        }
        Ui.showLine();
        System.out.println(
                " Here are the tasks in your list:"
        );
        //print out all list's items
        for (int i = 0; i < TaskList.getTasks().size(); i++) {
            TaskList.getTasks().get(i).displayListPerTask(i);
        }
        Ui.showLine();
    }

    //print delete task message
    public void displayDeleteMessage(Task removedTask) {
        showLine();
        System.out.printf(
                " Noted. I've removed this task:\n" +
                        "   [%s][%s] %s\n" +
                        " Now you have %d tasks in the list.\n",
                removedTask.getTaskType(), removedTask.getStatusIcon(), removedTask.getDescription(), TaskList.getTasks().size()
        );
        showLine();
    }

    //display bye message
    public void displayByeMessage() {
        showLine();
        System.out.print(" Bye. Hope to see you again soon!\n");
        showLine();
    }

    //display greeting message
    public void displayGreetingMessage() {
        showLine();
        System.out.print(
                " Hello! I'm Duke\n" +
                        " What can I do for you?\n");
        showLine();
    }

    //display file not found error message
    public static void displayFileNotFound() {
        showLine();
        System.out.println(
                " Are you first time user?\n" +
                        " I am unable to find your past data"
        );
        showLine();
    }

    public static void showLine() {
        System.out.println("____________________________________________________________");
    }

    /**
     * Receives user command.
     *
     * @return user command as string
     */
    public String readCommand() {
        //activate scanner
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void showError(String message) {
        System.out.println("Unable to continue because " + message);
    }
}
