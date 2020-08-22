package main.java;

import java.util.Scanner;

public class Duke {
    //echo user input
    public static void echoInput(String userInput){
        System.out.printf(
            "____________________________________________________________\n" +
            " %s\n" +
            "____________________________________________________________\n"
            ,userInput
        );
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
        
        //echo user's input until "bye" is entered
        while(!userInput.equals("bye")){
            echoInput(userInput);
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
