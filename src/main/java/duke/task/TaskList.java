package main.java.duke.task;

import main.java.duke.common.Constants;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks = new ArrayList<>(Constants.MAX_LIST_SIZE);

    public static ArrayList<Task> getTasks() {
        return tasks;
    }

    public static void addTasks(Task addedTask) {
        tasks.add(addedTask);
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex - 1);
    }

    public Task remove(int taskIndex) {
        return tasks.remove(taskIndex - 1);
    }

    public boolean checkEmpty() {
        if (tasks.isEmpty()) {
            return true;
        }
        return false;
    }
}