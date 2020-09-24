package main.java.duke;

import main.java.duke.command.Command;
import main.java.duke.common.Constants;
import main.java.duke.exception.DukeException;
import main.java.duke.task.TaskList;

import java.io.FileNotFoundException;

public class Duke {
    private final Ui ui;
    private final Storage storage;
    private final TaskList tasks = new TaskList();

    public Duke(String filePath) {
        ui = new Ui();
        ui.displayGreetingMessage();
        storage = new Storage(filePath);
        try {
            storage.loadPastData();
        } catch (FileNotFoundException e) {
            Ui.displayFileNotFound();
        }
    }

    public static void main(String[] args) {
        new Duke(Constants.filepath).run();
    }

    public void run() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Ui.showLine(); // show the divider line ("_______")
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                Ui.showLine();
            }
        }
    }

}
