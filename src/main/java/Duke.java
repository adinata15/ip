package main.java;

import java.util.Scanner;

public class Duke {
    private static String[] listItems=new String[100];//user's to-do-list (max 100 items)
    private static int listSize=0;//current list size
    
    //add input to list
    public static void addList(String userInput){
        listItems[listSize++]=userInput;
        System.out.printf(
            "____________________________________________________________\n" +
            " added: %s\n" +
            "____________________________________________________________\n"
            ,userInput
        );
    }
    
    //display current list
    public static void displayList(){
        System.out.printf(
                "____________________________________________________________\n");
        //print out all list's items
        for (int i=0;i< listSize;i++){
            System.out.printf(" %d. %s\n",i+1,listItems[i]);
        }
        System.out.printf(
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
            }else {
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
        
        return;
    }
}
