package main.java.duke;

import static main.java.duke.common.Constants.MAX_LIST_SIZE;
import static main.java.duke.common.Constants.MAX_TASK_LENGTH;
import main.java.duke.task.Deadline;
import main.java.duke.task.Event;
import main.java.duke.task.Task;
import main.java.duke.task.TaskList;
import main.java.duke.task.TaskType;
import main.java.duke.task.ToDo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Storage {
    private String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    //retrieve past saved data
    public void loadPastData() throws FileNotFoundException, NullPointerException {
        File pastFile = new File(filepath);
        String wholeDoc = null;

        //read previous data
        Scanner s = new Scanner(pastFile);
        while (s.hasNext()) {
            wholeDoc = s.nextLine();
        }

        //when file is empty or not created
        if (wholeDoc != null) {
            //separate entry based on ||
            String[] taskListFile = wholeDoc.split("\\|\\|", MAX_LIST_SIZE);
            for (int i = 0; i < taskListFile.length - 1; i++) {//minus one to negate for last || on file
                String[] taskDetails = taskListFile[i].split("\\|", MAX_TASK_LENGTH);
                switch (taskDetails[0]) {
                case "T":
                    TaskList.getTasks().add(new ToDo(taskDetails[2], TaskType.TODO, taskDetails[1]));
                    break;
                case "E":
                    TaskList.getTasks().add(new Event(taskDetails[2], TaskType.EVENT, LocalDate.parse(taskDetails[3]), taskDetails[1]));
                    break;
                case "D":
                    TaskList.getTasks().add(new Deadline(taskDetails[2], TaskType.DEADLINE, LocalDate.parse(taskDetails[3]), taskDetails[1]));
                    break;
                default:
                    System.out.println("Error occur on retrieving previous data");
                }
            }
        }
    }

    //save all list data
    public void saveData() {
        try {
            File storageFile = new File(filepath);
            if (!storageFile.getParentFile().exists()) {
                storageFile.getParentFile().mkdirs();
            }

            if (!storageFile.exists()) {
                storageFile.createNewFile();
            }

            FileWriter fw = new FileWriter(filepath, false);
            for (Task task : TaskList.getTasks()) {
                task.saveToFile(fw);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Cannot create file; reason: " + e.getMessage());
        }
    }
}