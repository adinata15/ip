# User Guide
Duke is a **chat-bot app to assist you in task management via a Command Line Interface**.

* [Quick Start](#quick-start)
* [Features](#features)
    * [Add a new Todo task: `todo`](#adding-a-new-todo-task-todo)
    * [Add a new Deadline task: `deadline`](#adding-a-new-deadline-task-deadline)
    * [Add a new Event task: `event`](#adding-a-new-event-task-event)
    * [List all tasks: `list`](#listing-all-tasks-list)
    * [Mark a task as done: `done`](#marking-a-task-as-done-done)
    * [Delete a task: `delete`](#deleting-a-task-delete)
    * [Finding a task: `find`](#finding-a-task-find)
    * [Exit the Duke: `bye`](#exiting-the-duke-bye)
    * [Save the data](#saving-the-data)
* [Command Summary](#command-summary)

## Quick Start 
1. Verify that you have Java 11 or above installed in your computer.
2. Download the latest `IP_Week_2.jar`.
3. Copy the file to a folder where you want to run it from.
4. Using the terminal, navigate to the path of `IP_Week_2.jar`.
5. Run `java -jar IP_Week_2.jar`
6. If the setup is correct, you should see a welcome message. Then, it is now ready to go.

## Features

### Adding a new Todo task: `todo`
Adds a Todo to the task list.

Format: `todo DESCRIPTION`

Example:
`todo Watch Crash Landing on You`

Expected output:
```
Got it. I've added this task:
[T][not done] Watch Crash Landing on You
Now you have 1 tasks in the list.
```

### Adding a new Deadline task: `deadline`
Adds a Deadline to the task list.

Format: `deadline DESCRIPTION /by TIME`

NB: TIME needs to be in YYYY-MM-DD format

Example:
`deadline Submit movie review /by 2020-12-12`

Expected output:
```
Got it. I've added this task:
[D][not done] Submit movie review (by: Dec 12 2020)
Now you have 2 tasks in the list.
```

### Adding a new Event task: `event`
Adds an Event to the task list.

Format: `event DESCRIPTION /at TIME`

NB: TIME needs to be in YYYY-MM-DD format

Example:
`event Netflix party /at 2020-12-12`

Expected output:
```
Got it. I've added this task:
[E][not done] Netflix party (at: Dec 12 2020)
Now you have 3 tasks in the list.
```

### Listing all tasks: `list`
Shows a list of all tasks.

Expected output:
```
Here are the tasks in your list:
1.[T][not done] Watch Crash Landing on You
2.[D][not done] Submit movie review (by: Dec 12 2020)
3.[E][not done] Netflix party (at: Dec 12 2020)
```
### Marking a task as done: `done`
Marks the specified task as done.

Format: `done TASK_INDENTIFIER`

Example:
`done 1`

Expected output:
```
Nice! I've marked this task as done:
[done] Watch Crash Landing on You
```

### Deleting a task: `delete`
Deletes the specified task from the task list.

Format: `delete TASK_IDENTIFIER`

Example:
`delete 1`

Expected output:
```
Noted. I've removed this task:
 [T][done] Watch Crash Landing on You
Now you have 2 tasks in the list.
```

### Finding a task: `find`
Finds task which description contains any of the given keywords.

Format: `find KEYWORD`

Example:
`find party`

Expected output:
```
Here are the matching tasks in your list:
1.[E][not done] Netflix party (at: Dec 12 2020)
```

### Exiting the Duke: `bye`
Exits the program.

Expected output:
```
Bye. Hope to see you again soon!
```

### Saving the data:

Duke data are saved in the hard disk automatically.

## Command Summary

**Action** | **Format, Examples**
------------ | -------------
**todo**|`todo DESCRIPTION` <br>e.g., `todo Watch Crash Landing on You`
**deadline**|`deadline DESCRIPTION /by TIME` <br>e.g., `deadline Submit movie review /by 2020-12-12`
**event**|`event DESCRIPTION /at TIME`<br>e.g., `event Netflix party /at 2020-12-12`
**list**|`list`
**done**|`done [TASK_IDENTIFIER]` <br>e.g., `done 1`
**delete**|`delete [TASK_IDENTIFIER]` <br>e.g., `delete 1`
**find**|`find [KEYWORD]`<br>e.g., `find party`
**exit**|`bye`

## Support and comment
Email [here](adinatatan99@gmail.com) for comments and extra support
