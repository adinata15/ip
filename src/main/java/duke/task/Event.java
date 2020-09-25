package main.java.duke.task;

import main.java.duke.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Event task functionalities.
 */
public class Event extends Task {
    private LocalDate at;//event time

    public Event(String description, TaskType taskType, LocalDate at) {
        super(description, taskType);
        this.at = at;
    }

    public Event(String description, TaskType taskType, LocalDate at, String doneStatus) {
        super(description, taskType, doneStatus);
        this.at = at;
    }

    //return event's at time
    public LocalDate getAt() {
        return at;
    }

    @Override
    //display event information on list
    public void displayListPerTask(int taskIndex) {
        System.out.printf(" %d.[%c][%s] %s (at: %s)\n"
                , taskIndex + 1, getTaskType(), getStatusIcon(), getDescription(), at.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
        );
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon().equals("done") ? "1" : "0") + "|"
                + getDescription() + "|" + at + "||";
        return textToAppend;
    }

    //respond after successful addition to list
    @Override
    public void respondOnAdd() {
        Ui.showLine();
        System.out.printf(
                " Got it. I've added this task:\n" +
                        "   [%c][%s] %s (at: %s)\n" +
                        " Now you have %d tasks in the list.\n"
                , getTaskType(), getStatusIcon(), getDescription(), at.format(DateTimeFormatter.ofPattern("MMM d yyyy")), TaskList.getTasks().size()
        );
        Ui.showLine();
    }
}
