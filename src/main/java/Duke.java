package main.java;

import java.util.Scanner;

public class Duke {
    private static Task[] tasks=new Task[100];//user's to-do-list (max 100 items)
    private static int listSize=0;//current list size
    
    //add input to list
    public static void addList(String userInput){
        Task task = new Task(userInput);
        tasks[listSize++] = task;
        System.out.printf(
            "____________________________________________________________\n" +
            " added: %s\n" +
            "____________________________________________________________\n"
            ,task.description
        );
    }
    
    //display current list
    public static void displayList(){
        System.out.print(
                "____________________________________________________________\n"+
                " Here are the tasks in your list:\n"
        );
        //print out all list's items
        for (int i = 0;i < listSize;i++){
            System.out.printf(" %d.[%s] %s\n",i+1,tasks[i].getStatusIcon(),tasks[i].description);
        }
        System.out.print(
                "____________________________________________________________\n");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String userInput; //user input
        
        //greeting message
        System.out.print(
            "____________________________________________________________\n" +
            " Hello! I'm Duke\n" +
            " What can I do for you?\n" +
            "____________________________________________________________\n"
        );
        //scan user's input
        userInput = input.nextLine();
        
        //execute command based on user's input until "bye" is entered
        while(!userInput.equals("bye")){
            //display list
            if(userInput.equals("list")){
                displayList();
            } else if(userInput.startsWith("done")){
                //take word after "done" as task index
                String taskIndexString = userInput.split(" ")[1];
                Integer taskIndex = Integer.parseInt(taskIndexString);
                //mark task as done
                tasks[taskIndex-1].markAsDone();
            } else {
                //add user input to list
                addList(userInput);
            }
            userInput = input.nextLine();
        }
        
        //bye message
        System.out.print(
            "____________________________________________________________\n"+
            " Bye. Hope to see you again soon!\n"+
            "____________________________________________________________\n"
        );
    }
}
