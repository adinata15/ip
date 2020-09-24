package main.java.duke.task;

import main.java.duke.Ui;

public class ToDo extends Task {
    public ToDo(String description, TaskType taskType) {
        super(description, taskType);
    }

    public ToDo(String description, TaskType taskType, String doneStatus) {
        super(description, taskType, doneStatus);
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon() == "\u2713" ? "1" : "0")
                + "|" + getDescription() + "||";
        return textToAppend;
    }

    //respond after successful addition to list
    @Override
    public void respondOnAdd() {
        Ui.showLine();
        System.out.printf(
                " Got it. I've added this task:\n" +
                        "   [%c][%s] %s\n" +
                        " Now you have %d tasks in the list.\n"
                , getTaskType(), getStatusIcon(), getDescription(), TaskList.getTasks().size()
        );
        Ui.showLine();
    }
}
