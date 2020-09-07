package main.java.duke;

import main.java.duke.exception.EmptyTodoException;
import main.java.duke.exception.InvalidCommandException;
import main.java.duke.task.Deadline;
import main.java.duke.task.Event;
import main.java.duke.task.Task;
import main.java.duke.task.TaskType;
import main.java.duke.task.ToDo;

import java.util.Scanner;

public class Duke {
    public static final int MAX_LIST_SIZE = 100;
    private static Task[] tasks = new Task[MAX_LIST_SIZE];//user's to-do-list (max 100 items)
    private static int listSize = 0;//current list size

    //get current list size
    public static int getListSize() {
        return listSize;
    }

    //add user input to list
    public static void addList(String userInput) throws InvalidCommandException {
        //first word of user's input
        String userInputFirstWord = userInput.split(" ")[0];
        //create task type based on user input
        switch (userInputFirstWord) {
        case "todo":
            try {
                addTodo(userInput);
            } catch (EmptyTodoException e) {
                displayEmptyTodoMessage();
            }
            break;
        case "deadline":
            addDeadline(userInput);
            break;
        case "event":
            addEvent(userInput);
            break;
        default:
            throw new InvalidCommandException();
        }
    }

    //add event to list
    private static void addEvent(String userInput) {
        TaskType taskType;
        String description;

        //start and end index for description
        int taskDescriptionStartIndex;
        int taskDescriptionEndIndex;

        //find start of task description
        taskDescriptionStartIndex = userInput.indexOf(" ");
        taskDescriptionEndIndex = userInput.indexOf("/at");
        //assign task's information
        description = userInput.substring(taskDescriptionStartIndex + 1, taskDescriptionEndIndex).trim();
        String at = userInput.substring(taskDescriptionEndIndex + 3).trim();//+3 to exclude "/at"
        taskType = TaskType.EVENT;
        //create and assign information to new event
        Event event = new Event(description, taskType, at);
        tasks[listSize++] = event;
    }

    //add deadline to list
    private static void addDeadline(String userInput) {
        TaskType taskType;
        String description;

        //start and end index for description
        int taskDescriptionStartIndex;
        int taskDescriptionEndIndex;

        //find start of task description
        taskDescriptionStartIndex = userInput.indexOf(" ");
        taskDescriptionEndIndex = userInput.indexOf("/by");
        //assign task's information
        description = userInput.substring(taskDescriptionStartIndex + 1, taskDescriptionEndIndex).trim();
        String by = userInput.substring(taskDescriptionEndIndex + 3).trim();//+3 to exclude "/by"
        taskType = TaskType.DEADLINE;
        //create and assign information to new deadline
        Deadline deadline = new Deadline(description, taskType, by);
        tasks[listSize++] = deadline;
    }

    //add todo to list
    private static void addTodo(String userInput) throws EmptyTodoException {
        TaskType taskType;
        String description;

        //start index for description
        int taskDescriptionStartIndex;

        //find start of task description
        taskDescriptionStartIndex = userInput.indexOf(" ");
        //assign task's information
        description = userInput.substring(taskDescriptionStartIndex + 1);
        //check whether todo description is valid
        if (taskDescriptionStartIndex != 4 || description.isEmpty()) { //4 is for "todo" letter
            throw new EmptyTodoException();
        }
        taskType = TaskType.TODO;
        //create and assign information to new ToDo
        ToDo toDo = new ToDo(description, taskType);
        tasks[listSize++] = toDo;
    }

    //display current list
    public static void displayList() {
        System.out.print(
                "____________________________________________________________\n" +
                        " Here are the tasks in your list:\n"
        );
        //print out all list's items
        for (int i = 0; i < listSize; i++) {
            tasks[i].displayListPerTask(i);
        }
        System.out.print(
                "____________________________________________________________\n"
        );
    }

    //handle user input commands
    private static void handleCommand() {
        //activate scanner
        Scanner input = new Scanner(System.in);
        String userInput; //user input

        //scan user's input
        userInput = input.nextLine();

        //execute command based on user's input until "bye" is entered
        while (!userInput.equals("bye")) {
            if (userInput.equals("list")) {
                //display list
                displayList();
            } else if (userInput.startsWith("done")) {
                //mark the given activity as done
                markDone(userInput);
            } else {
                //add user input to list
                try {
                    addList(userInput);
                } catch (InvalidCommandException e) {
                    displayInvalidCommandMessage();
                }
            }
            //receive next user command
            userInput = input.nextLine();
        }
    }

    //mark an activity as done
    private static void markDone(String userInput) {
        //take word after "done" as task index
        String taskIndexString = userInput.split(" ")[1];
        // convert taskIndexString into an integer
        int taskIndex = Integer.parseInt(taskIndexString);
        //mark task as done
        tasks[taskIndex - 1].markAsDone();
    }

    //display bye message
    private static void displayByeMessage() {
        System.out.print(
                "____________________________________________________________\n" +
                        " Bye. Hope to see you again soon!\n" +
                        "____________________________________________________________\n"
        );
    }

    //display greeting message
    private static void displayGreetingMessage() {
        System.out.print(
                "____________________________________________________________\n" +
                        " Hello! I'm Duke\n" +
                        " What can I do for you?\n" +
                        "____________________________________________________________\n"
        );
    }

    //display error when invalid command
    private static void displayInvalidCommandMessage() {
        System.out.print(
                "____________________________________________________________\n" +
                        " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n" +
                        "____________________________________________________________\n"
        );
    }

    //display error when todo field is empty
    private static void displayEmptyTodoMessage() {
        System.out.print(
                "____________________________________________________________\n" +
                        " ☹ OOPS!!! The description of a todo cannot be empty.\n" +
                        "____________________________________________________________\n"
        );
    }

    //main function
    public static void main(String[] args) {
        displayGreetingMessage();
        handleCommand();
        displayByeMessage();
    }
}
