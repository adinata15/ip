package main.java.duke.task;

import main.java.duke.Duke;

public class Task {
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

    //print out done/undone symbol
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

    //mark task as done
    public void markAsDone() {
        isDone = true;
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
}
