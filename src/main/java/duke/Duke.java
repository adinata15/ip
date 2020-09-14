package main.java.duke;

import main.java.duke.exception.EmptyTodoException;
import main.java.duke.exception.InvalidCommandException;
import main.java.duke.task.Deadline;
import main.java.duke.task.Event;
import main.java.duke.task.Task;
import main.java.duke.task.TaskType;
import main.java.duke.task.ToDo;


import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static final int MAX_LIST_SIZE = 100;
    private static ArrayList<Task> tasks = new ArrayList<>(MAX_LIST_SIZE);//user's to-do-list (max 100 items)
    public static final int MAX_TASK_LENGTH = 4;
    public static final String filepath = "./data/duke.txt";//file path from root file

    //get list size
    public static int getListSize() {
        return tasks.size();
    }

    //retrieve past saved data
    private static void handlePastData() {
        File pastFile = new File(filepath); // create a File for the given file path
        String wholeDoc = readFile(pastFile);
        //when file is empty or not created
        if (wholeDoc == null) {
            return;//skip parsing data
        }
        //convert file entry to tasks
        parseFile(wholeDoc);
    }

    //read file content
    private static String readFile(File pastFile) {
        String wholeDoc = null;
        try {
            //read previous data
            Scanner s = new Scanner(pastFile);
            while (s.hasNext()) {
                wholeDoc = s.nextLine();
            }
        } catch (FileNotFoundException e) {
            printFileNotFound();
            return null;
        }
        return wholeDoc;
    }

    //display file not found error message
    private static void printFileNotFound() {
        System.out.println(" Are you first time user?\n" +
                " I am unable to find your past data\n" +
                "____________________________________________________________");
    }

    //convert file entry to tasks
    private static void parseFile(String wholeDoc) {
        //separate entry based on ||
        String[] taskListFile = wholeDoc.split("\\|\\|", MAX_LIST_SIZE);
        for (int i = 0; i < taskListFile.length - 1; i++) {//minus one to negate for last || on file
            String[] taskDetails = taskListFile[i].split("\\|", MAX_TASK_LENGTH);
            switch (taskDetails[0]) {
            case "T":
                addToDoFile(taskDetails);
                break;
            case "E":
                addEventFile(taskDetails);
                break;
            case "D":
                addDeadlineFile(taskDetails);
                break;
            default:
                System.out.println("Error occur on retrieving previous data");
            }
        }
    }

    //add deadline from file
    private static void addDeadlineFile(String[] taskDetails) {
        Deadline deadline = new Deadline(taskDetails[2], TaskType.DEADLINE, taskDetails[3]);
        tasks.add(deadline);
        if (taskDetails[1].equals("1")) {
            tasks.get(tasks.size()-1).markAsDone();
        }
    }

    //add event from file
    private static void addEventFile(String[] taskDetails) {
        Event event = new Event(taskDetails[2], TaskType.EVENT, taskDetails[3]);
        tasks.add(event);
        if (taskDetails[1].equals("1")) {
            tasks.get(tasks.size()-1).markAsDone();
        }
    }

    //add todo from file
    private static void addToDoFile(String[] taskDetails) {
        ToDo toDo = new ToDo(taskDetails[2], TaskType.TODO);
        tasks.add(toDo);
        if (taskDetails[1].equals("1")) {
            tasks.get(tasks.size()-1).markAsDone();
        }
    }

    //save all list data
    private static void saveData() {
        try {
            FileWriter fw = new FileWriter(filepath, false);
            for (Task task:tasks) {
                task.saveToFile(fw);
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        tasks.get(tasks.size()-1).respondOnAdd();
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
        tasks.add(event);
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
        tasks.add(deadline);
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
        tasks.add(toDo);
    }

    //display current list
    public static void displayList() {
        System.out.print(
                "____________________________________________________________\n" +
                        " Here are the tasks in your list:\n"
        );
        //print out all list's items
        for (int i = 0; i < tasks.size(); i++) {
            tasks.get(i).displayListPerTask(i);
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
            } else if (userInput.startsWith("delete")) {
                //delete the given activity
                deleteTask(userInput);
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
        tasks.get(taskIndex-1).markAsDone();
        tasks.get(taskIndex-1).printDoneMsg();
    }

    //delete an activity
    private static void deleteTask(String userInput) {
        //take word after "delete" as task index
        String taskIndexString = userInput.split(" ")[1];
        // convert taskIndexString into an integer
        int taskIndex = Integer.parseInt(taskIndexString);
        //leave out the removed task from list
        Task removedTask = tasks.remove(taskIndex-1);
        displayDeleteMessage(removedTask);
    }

    //print delete task message
    public static void displayDeleteMessage(Task removedTask) {
        System.out.printf(
                "____________________________________________________________\n" +
                        " Noted. I've removed this task:\n" +
                        "   [%s][%s] %s\n" +
                        " Now you have %d tasks in the list.\n" +
                        "____________________________________________________________\n",
                removedTask.getTaskType(), removedTask.getStatusIcon(), removedTask.getDescription(), tasks.size()
        );
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
        handlePastData();
        handleCommand();
        saveData();
        displayByeMessage();
    }
}
