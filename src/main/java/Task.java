package main.java;

public class Task {
    protected String description;//task description
    protected boolean isDone;//task condition
    
    public Task(String description) {
        this.description = description;
        isDone = false;
    }
    
    //print out done/undone symbol
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    
    //mark task as done
    public void markAsDone(){
        isDone = true;
        System.out.printf(
                "____________________________________________________________\n" +
                " Nice! I've marked this task as done:\n" +
                " [%s] %s\n" +
                "____________________________________________________________\n"
                , getStatusIcon(),description
        );
    }
}
