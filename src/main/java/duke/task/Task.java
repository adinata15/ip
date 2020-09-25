package main.java.duke.task;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Task functionalities and objects.
 */
public abstract class Task {
    private final String description;
    private boolean isDone;//task condition
    private final TaskType taskType;

    public Task(String description, TaskType taskType) {
        this.description = description;
        this.taskType = taskType;
        isDone = false;
    }

    public Task(String description, TaskType taskType, String doneStatus) {
        this.description = description;
        this.taskType = taskType;
        isDone = doneStatus.equals(1);
    }

    //get task description
    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "done" : "not done");
    }


    //get task type character
    public char getTaskType() {
        char taskTypeChar;//char to represent task type
        switch (taskType) {
        case TODO:
            taskTypeChar = 'T';
            break;
        case EVENT:
            taskTypeChar = 'E';
            break;
        case DEADLINE:
            taskTypeChar = 'D';
            break;
        default:
            taskTypeChar = 'U';//undefined task type
            break;
        }
        return taskTypeChar;
    }

    //save task to file
    public void saveToFile(FileWriter fw) {
        String textToAppend = getStringToFile();
        try {
            fw.write(textToAppend);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //mark task as done
    public void markAsDone() {
        isDone = true;
    }

    //print task done message
    public void printDoneMsg() {
        System.out.printf(
                "____________________________________________________________\n" +
                        " Nice! I've marked this task as done:\n" +
                        " [%s] %s\n" +
                        "____________________________________________________________\n"
                , getStatusIcon(), description
        );
    }

    //display task information on list
    public void displayListPerTask(int taskIndex) {
        System.out.printf(" %d.[%c][%s] %s\n"
                , taskIndex + 1, getTaskType(), getStatusIcon(), getDescription()
        );
    }

    //abstract methods
    public abstract String getStringToFile();

    public abstract void respondOnAdd();
}
