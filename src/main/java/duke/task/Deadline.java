package main.java.duke.task;

import main.java.duke.Duke;

public class Deadline extends Task {
    private String by;//deadline due time

    public Deadline(String description, TaskType taskType, String by) {
        super(description, taskType);
        this.by = by;
    }

    @Override
    //respond after successful addition to list
    public void respondOnAdd() {
        System.out.printf(
                "____________________________________________________________\n" +
                        " Got it. I've added this task:\n" +
                        "   [%c][%s] %s (by: %s)\n" +
                        " Now you have %d tasks in the list.\n" +
                        "____________________________________________________________\n"
                , getTaskType(), getStatusIcon(), getDescription(), getBy(), Duke.getListSize()
        );
    }

    //return deadline's by time
    public String getBy() {
        return by;
    }

    @Override
    //display deadline information on list
    public void displayListPerTask(int taskIndex) {
        System.out.printf(" %d.[%c][%s] %s (by: %s)\n"
                , taskIndex + 1, getTaskType(), getStatusIcon(), getDescription(), by
        );
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon()=="\u2713"?"1":"0") + "|" + getDescription() + "|" + getBy() + "||";
        return textToAppend;
    }
}
