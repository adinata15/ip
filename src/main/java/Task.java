package main.java;

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
        switch (taskType){
        case TODO:
            //return type will break the execution of the function
            //if break is used, error will appear as the break is unreachable
            return 'T';
        case EVENT:
            return 'E';
        case DEADLINE:
            return 'D';
        default:
            return 'U';//undefined task type
        }
    }
    
    //mark task as done
    public void markAsDone(){
        isDone = true;
        System.out.printf(
                "____________________________________________________________\n" +
                " Nice! I've marked this task as done:\n" +
                " [%s] %s\n" +
                "____________________________________________________________\n"
                ,getStatusIcon(),description
        );
    }
    
    //display task information on list
    public void displayListPerTask(int taskIndex){
        System.out.printf(" %d.[%c][%s] %s\n"
                ,taskIndex+1,getTaskType(),getStatusIcon(),getDescription()
        );
    }
}
