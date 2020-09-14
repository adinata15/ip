package main.java.duke.task;

import main.java.duke.Duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Task {
    private String description;//task description
    private boolean isDone;//task condition
    private TaskType taskType;//task type

    public Task(String description, TaskType taskType) {
        this.description = description;
        this.taskType = taskType;
        isDone = false;
    }

    //get task description
    public String getDescription() {
        return description;
    }

    //print out done/undone symbol
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
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

    //respond after successful addition to list
    public abstract void respondOnAdd();

    //generate string for File save
    public abstract String getStringToFile();
}
