package main.java.duke.task;

import main.java.duke.Duke;

public class ToDo extends Task {
    public ToDo(String description, TaskType taskType) {
        super(description, taskType);
    }

    @Override
    //respond after successful addition to list
    public void respondOnAdd() {
        System.out.printf(
                "____________________________________________________________\n" +
                        " Got it. I've added this task:\n" +
                        "   [%c][%s] %s\n" +
                        " Now you have %d tasks in the list.\n" +
                        "____________________________________________________________\n"
                , getTaskType(), getStatusIcon(), getDescription(), Duke.getListSize()
        );
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon()=="\u2713"?"1":"0") + "|" + getDescription() + "||";
        return textToAppend;
    }
}
