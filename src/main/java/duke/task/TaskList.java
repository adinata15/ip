package main.java.duke.task;

import main.java.duke.common.Constants;

import java.util.ArrayList;

/**
 * Provides general task list object and functionalities for Duke.
 */
public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<>(Constants.MAX_LIST_SIZE); //Duke task list

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTasks(Task addedTask) {
        tasks.add(addedTask);
    }

    /**
     * Retrieve specific task from task list.
     *
     * @param taskIndex index of task to be retrieved
     * @return requested task
     */
    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex - 1);
    }

    public Task remove(int taskIndex) {
        return tasks.remove(taskIndex - 1);
    }

    /**
     * Check the content of task list.
     *
     * @return state of task (empty or not)
     */
    public boolean checkEmpty() {
        if (tasks.isEmpty()) {
            return true;
        }
        return false;
    }
}