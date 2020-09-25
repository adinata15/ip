package main.java.duke.task;

import main.java.duke.Ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Deadline task functionalities.
 */
public class Deadline extends Task {
    private LocalDate by;//deadline due time

    public Deadline(String description, TaskType taskType, LocalDate by) {
        super(description, taskType);
        this.by = by;
    }

    public Deadline(String description, TaskType taskType, LocalDate by, String doneStatus) {
        super(description, taskType, doneStatus);
        this.by = by;
    }

    //return deadline's by time
    public LocalDate getBy() {
        return by;
    }

    @Override
    //display deadline information on list
    public void displayListPerTask(int taskIndex) {
        System.out.printf(" %d.[%c][%s] %s (by: %s)\n"
                , taskIndex + 1, getTaskType(), getStatusIcon(), getDescription(), by.format(DateTimeFormatter.ofPattern("MMM d yyyy"))
        );
    }

    @Override
    //generate string for File save
    public String getStringToFile() {
        String textToAppend = getTaskType() + "|" + (getStatusIcon().equals("done") ? "1" : "0") + "|"
                + getDescription() + "|" + by + "||";
        return textToAppend;
    }

    //respond after successful addition to list
    @Override
    public void respondOnAdd() {
        Ui.showLine();
        System.out.printf(
                " Got it. I've added this task:\n" +
                        "   [%c][%s] %s (by: %s)\n" +
                        " Now you have %d tasks in the list.\n"
                , getTaskType(), getStatusIcon(), getDescription(), by.format(DateTimeFormatter.ofPattern("MMM d yyyy")), TaskList.getTasks().size()
        );
        Ui.showLine();
    }
}
