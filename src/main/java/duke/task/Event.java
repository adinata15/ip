package main.java.duke.task;

import main.java.duke.Duke;

public class Event extends Task {
    private String at;//event time

    public Event(String description, TaskType taskType, String at) {
        super(description, taskType);
        this.at = at;
    }

    @Override
    //respond after successful addition to list
    public void respondOnAdd() {
        System.out.printf(
                "____________________________________________________________\n" +
                        " Got it. I've added this task:\n" +
                        "   [%c][%s] %s (at: %s)\n" +
                        " Now you have %d tasks in the list.\n" +
                        "____________________________________________________________\n"
                , getTaskType(), getStatusIcon(), getDescription(), getAt(), Duke.getListSize()
        );
    }

    //return event's at time
    public String getAt() {
        return at;
    }

    @Override
    //display event information on list
    public void displayListPerTask(int taskIndex) {
        System.out.printf(" %d.[%c][%s] %s (at: %s)\n"
                , taskIndex + 1, getTaskType(), getStatusIcon(), getDescription(), at
        );
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon()=="\u2713"?"1":"0") + "|" + getDescription() + "|" + getAt() + "||";
        return textToAppend;
    }
}
