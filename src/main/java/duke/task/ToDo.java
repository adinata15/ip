package main.java.duke;

public class ToDo extends Task{
    public ToDo(String description,TaskType taskType) {
        super(description,taskType);
        respondOnAdd();
    }
    //respond after successful addition to list
    private void respondOnAdd() {
        System.out.printf(
                "____________________________________________________________\n" +
                " Got it. I've added this task:\n"+
                "   [%c][%s] %s\n"+
                " Now you have %d tasks in the list.\n" +
                "____________________________________________________________\n"
                ,getTaskType(),getStatusIcon(),getDescription(),Duke.getListSize()+1
        );
    }
}
